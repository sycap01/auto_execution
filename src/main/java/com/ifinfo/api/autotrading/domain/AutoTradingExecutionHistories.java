package com.ifinfo.api.autotrading.domain;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryResponse;
import com.ifinfo.api.infra.support.base.BaseEntity;
import com.ifinfo.api.infra.support.util.CommonUtil;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "auto_trading_execution_histories", indexes = {
        @Index(name = "i_auto_trading_execution_histories_status_category_code", columnList = "status_category_code")
})
public class AutoTradingExecutionHistories extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "status_category_code")
    private String statusCategoryCode;

    @Column(name = "start_datetime")
    private String startDatetime;

    @Column(name = "end_datetime")
    private String endDatetime;

    @Column(nullable = false, name = "cancel_yn")
    private String cancelYn;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auto_trading_execution_id", referencedColumnName = "id", nullable = false)
    private AutoTradingExecutions autoTradingExecution;

    /* =================================================================
    * Relation method
    ================================================================= */

    public AutoTradingExecutionHistoryResponse ofDetailResponse() {
        AutoTradingExecutionHistoryResponse response = ofResponse();
        return response;
    }

    public AutoTradingExecutionHistoryResponse ofResponse() {
        AutoTradingExecutionHistoryResponse response = AutoTradingExecutionHistoryResponse.builder()
                .statusCategoryCode(statusCategoryCode)
                .startDatetime(startDatetime)
                .endDatetime(endDatetime)
                .cancelYn(cancelYn)
                .build();
//        response.setAutoTradingExecution(autoTradingExecution.ofResponse());
        return response;
    }

    /* =================================================================
   * Business login
   ================================================================= */

    public void register() {
        checkAutoTradingExecutionHistory();
    }

    private void checkAutoTradingExecutionHistory() {

    }

    public void modify(@NonNull AutoTradingExecutionHistoryModify modify) {
        if (!CommonUtil.isNullOrBlank(modify.getStatusCategoryCode())) {
            statusCategoryCode = modify.getStatusCategoryCode();
        }
        if (!CommonUtil.isNullOrBlank(modify.getStartDatetime())) {
            startDatetime = modify.getStartDatetime();
        }
        if (!CommonUtil.isNullOrBlank(modify.getEndDatetime())) {
            endDatetime = modify.getEndDatetime();
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


}
