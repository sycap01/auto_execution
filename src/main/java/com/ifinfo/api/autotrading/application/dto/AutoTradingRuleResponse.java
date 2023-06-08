package com.ifinfo.api.autotrading.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AutoTradingRuleResponse {
    private Long id;
    private String tradingRuleName;
    private BigDecimal buyAmount;
    private BigDecimal sellAmount;
    private BigDecimal buyMinSpread;
    private BigDecimal buyMaxSpread;
    private BigDecimal sellMinSpread;
    private BigDecimal sellMaxSpread;
    private BigDecimal renewalCycleValue;
    private String renewalCategoryCode;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<AutoTradingExecutionResponse> autoTradingExecutions;
}
