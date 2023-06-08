package com.ifinfo.api.autotrading.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AutoTradingExecutionHistoryResponse {
    private AutoTradingExecutionResponse autoTradingExecution;
    private String statusCategoryCode;
    private String startDatetime;
    private String endDatetime;
    private String cancelYn;
}
