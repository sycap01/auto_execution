package com.ifinfo.api.autotrading.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ifinfo.api.autotrading.domain.AutoTradingExecutionHistories;
import com.ifinfo.api.autotrading.domain.AutoTradingExecutions;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "자동트레이딩이력 등록정보")
public class AutoTradingExecutionHistoryRegister {

    private AutoTradingExecutions autoTradingExecution;
    private String statusCategoryCode;

    public AutoTradingExecutionHistories ofEntity() {
        return AutoTradingExecutionHistories.builder()
                .statusCategoryCode(statusCategoryCode)
                .autoTradingExecution(autoTradingExecution)
                .cancelYn("N")
                .build();
    }
}
