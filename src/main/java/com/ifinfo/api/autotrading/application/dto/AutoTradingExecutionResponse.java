package com.ifinfo.api.autotrading.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ifinfo.api.autotrading.domain.AutoTradingRules;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AutoTradingExecutionResponse {
    private Long id;
    private Long productId;
    private String bookNo;
    private String marketCategoryCode;
    private String creationDate;
    private String writingUserNo;
    private String tradingStartCategoryCode;
    private String tradingEndCategoryCode;
    private String startReserveDatetime;
    private String endReserveDatetime;
    private String remarkContent;
    private String cancelYn;

    private AutoTradingRuleResponse autoTradingRule;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<AutoTradingExecutionHistoryResponse> autoTradingExecutionHistories;
}
