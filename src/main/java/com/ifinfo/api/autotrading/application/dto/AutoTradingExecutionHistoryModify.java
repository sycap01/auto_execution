package com.ifinfo.api.autotrading.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AutoTradingExecutionHistoryModify {

    @Schema(description = "트레이딩상태구분코드", defaultValue = "01")
    private String statusCategoryCode;

    private String startDatetime;

    private String endDatetime;
}
