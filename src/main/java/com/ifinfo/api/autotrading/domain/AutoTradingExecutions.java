package com.ifinfo.api.autotrading.domain;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionResponse;
import com.ifinfo.api.infra.support.base.BaseEntity;
import com.ifinfo.api.infra.support.util.CommonUtil;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "auto_trading_executions", indexes = {
        @Index(name = "i_auto_trading_executions_book_no", columnList = "book_no"),
        @Index(name = "i_auto_trading_executions_market_category_code", columnList = "market_category_code")
})
public class AutoTradingExecutions extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "product_id")
    private Long productId;

    @Column(nullable = false, name = "book_no")
    private String bookNo;

    @Column(nullable = false, name = "market_category_code")
    private String marketCategoryCode;

    @Column(name = "creation_date")
    private String creationDate;

    @Column(name = "writing_user_no")
    private String writingUserNo;

    @Column(nullable = false, name = "trading_start_category_code")
    private String tradingStartCategoryCode;

    @Column(nullable = false, name = "trading_end_category_code")
    private String tradingEndCategoryCode;

    @Column(name = "start_reserve_datetime")
    private String startReserveDatetime;

    @Column(name = "end_reserve_datetime")
    private String endReserveDatetime;

    @Column(name = "remark_content")
    private String remarkContent;

    @Column(nullable = false, name = "cancel_yn")
    private String cancelYn;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_trading_rule_id")
    private AutoTradingRules autoTradingRule;

    /* =================================================================
     * Domain mapping
     ================================================================= */
    @Builder.Default
    @OneToMany(mappedBy = "autoTradingExecution", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<AutoTradingExecutionHistories> autoTradingExecutionHistories = new HashSet<>();

    /* =================================================================
   * Relation method
   ================================================================= */
    public AutoTradingExecutionResponse ofDetailResponse() {
        AutoTradingExecutionResponse response = ofResponse();
        return response;
    }

    public AutoTradingExecutionResponse ofResponse() {
        AutoTradingExecutionResponse response = AutoTradingExecutionResponse
                .builder()
                .productId(productId)
                .bookNo(bookNo)
                .marketCategoryCode(marketCategoryCode)
                .creationDate(creationDate)
                .writingUserNo(writingUserNo)
                .tradingStartCategoryCode(tradingStartCategoryCode)
                .tradingEndCategoryCode(tradingEndCategoryCode)
                .startReserveDatetime(startReserveDatetime)
                .endReserveDatetime(endReserveDatetime)
                .remarkContent(remarkContent)
                .cancelYn(cancelYn)
                .build();
        response.setAutoTradingRule(autoTradingRule.ofResponse());

        if (CollectionUtils.isNotEmpty(autoTradingExecutionHistories)) {
            response.setAutoTradingExecutionHistories(autoTradingExecutionHistories.stream()
                    .filter(AutoTradingExecutionHistories::isNotDeleted)
                    .map(AutoTradingExecutionHistories::ofResponse).collect(toSet()));
        }
        return response;
    }

    /* =================================================================
   * Business login
   ================================================================= */

    public void register() {
        checkAutoTradingExecution();
    }

    private void checkAutoTradingExecution() {

    }


    public void modify(@NonNull AutoTradingExecutionModify modify) {
        if (!CommonUtil.isNullOrBlank(modify.getBookNo())) {
            bookNo = modify.getBookNo();
        }
        if (!CommonUtil.isNullOrBlank(modify.getWritingUserNo())) {
            writingUserNo = modify.getWritingUserNo();
        }
        if (!CommonUtil.isNullOrBlank(modify.getMarketCategoryCode())) {
            marketCategoryCode = modify.getMarketCategoryCode();
        }
        if (!CommonUtil.isNullOrBlank(modify.getTradingStartCategoryCode())) {
            tradingStartCategoryCode = modify.getTradingStartCategoryCode();
        }
        if (!CommonUtil.isNullOrBlank(modify.getTradingEndCategoryCode())) {
            tradingEndCategoryCode = modify.getTradingEndCategoryCode();
        }
        if (!CommonUtil.isNullOrBlank(modify.getStartReserveDatetime())) {
            startReserveDatetime = modify.getStartReserveDatetime();
        }
        if (!CommonUtil.isNullOrBlank(modify.getEndReserveDatetime())) {
            endReserveDatetime = modify.getEndReserveDatetime();
        }
        if (!CommonUtil.isNullOrBlank(modify.getRemarkContent())) {
            remarkContent = modify.getRemarkContent();
        }
    }

    public boolean isNotDeleted() {
        return !isDeleted();
    }

    public boolean isDeleted() {
        return ("Y").equals(cancelYn);
    }

    public void delete() {
        cancelYn = "Y";
    }

    public void setAutoTradingRule(@NonNull AutoTradingRules autoTradingRule) {
        autoTradingRule.validAutoTradingRule();
        this.autoTradingRule = autoTradingRule;
    }
}
