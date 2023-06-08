package com.ifinfo.api.autotrading.domain;

import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleResponse;
import com.ifinfo.api.infra.support.base.BaseEntity;
import com.ifinfo.api.infra.support.exception.ApiException;
import com.ifinfo.api.infra.support.exception.ErrorInfo;
import com.ifinfo.api.infra.support.util.CommonUtil;
import jakarta.persistence.*;
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "auto_trading_rules", indexes = {
        @Index(name = "i_auto_trading_rules_renewal_category_code", columnList = "renewal_category_code")
})
public class AutoTradingRules extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "trading_rule_name")
    private String tradingRuleName;

    @Column(nullable = false, name = "buy_amount")
    private BigDecimal buyAmount;

    @Column(nullable = false, name = "sell_amount")
    private BigDecimal sellAmount;

    @Column(nullable = false, name = "buy_min_spread")
    private BigDecimal buyMinSpread;

    @Column(nullable = false, name = "buy_max_spread")
    private BigDecimal buyMaxSpread;

    @Column(nullable = false, name = "sell_min_spread")
    private BigDecimal sellMinSpread;

    @Column(nullable = false, name = "sell_max_spread")
    private BigDecimal sellMaxSpread;

    @Column(nullable = false, name = "renewal_cycle_value")
    private BigDecimal renewalCycleValue;

    @Column(nullable = false, name = "renewal_category_code")
    private String renewalCategoryCode;

    @Column(nullable = false, name = "cancel_yn")
    private String cancelYn;

    /* =================================================================
     * Domain mapping
     ================================================================= */
    @Builder.Default
    @OneToMany(mappedBy = "autoTradingRule", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final Set<AutoTradingExecutions> autoTradingExecutions = new HashSet<>();

    /* =================================================================
    * Relation method
    ================================================================= */


    public AutoTradingRuleResponse ofDetailResponse() {
        AutoTradingRuleResponse response = ofResponse();
        return response;
    }

    public AutoTradingRuleResponse ofResponse() {
        AutoTradingRuleResponse response = AutoTradingRuleResponse.builder()
                .id(id).tradingRuleName(tradingRuleName).buyAmount(buyAmount).sellAmount(sellAmount)
                .buyMinSpread(buyMinSpread).buyMaxSpread(buyMaxSpread).sellMinSpread(sellMinSpread)
                .sellMaxSpread(sellMaxSpread).renewalCycleValue(renewalCycleValue).renewalCategoryCode(renewalCategoryCode)
                .build();
        return response;
    }

    public void validAutoTradingRule() {
        if (!isUsable()) {
            throw new ApiException(ErrorInfo.ERROR_0001,"사용할 수 없는 규칙 입니다.");
        }
    }
    public boolean isUsable() {
        return "N".equals(cancelYn);
    }
    /* =================================================================
   * Business login
   ================================================================= */
    public void register() {
        checkAutoTradingRule();
    }

    private void checkAutoTradingRule() {

    }


    public boolean isDeleted() {
        return cancelYn.equals("Y");
    }

    public void modify(@NonNull AutoTradingRuleModify modify) {
        if (!CommonUtil.isNullOrBlank(modify.getRenewalCategoryCode())) {
            renewalCategoryCode = modify.getRenewalCategoryCode();
        }
        if (!CommonUtil.isNullOrBlank(modify.getTradingRuleName())) {
            tradingRuleName = modify.getTradingRuleName();
        }
        if (modify.getBuyAmount() != null) {
            buyAmount = modify.getBuyAmount();
        }
        if (modify.getSellAmount() != null) {
            sellAmount = modify.getSellAmount();
        }
        if (modify.getBuyMinSpread() != null) {
            buyMinSpread = modify.getBuyMinSpread();
        }
        if (modify.getBuyMaxSpread() != null) {
            buyMaxSpread = modify.getBuyMaxSpread();
        }
        if (modify.getSellMinSpread() != null) {
            sellMinSpread = modify.getSellMinSpread();
        }
        if (modify.getSellMaxSpread() != null) {
            sellMaxSpread = modify.getSellMaxSpread();
        }
        if (modify.getRenewalCycleValue() != null) {
            renewalCycleValue = modify.getRenewalCycleValue();
        }
    }

    public void delete() {
        cancelYn = "Y";
    }


}
