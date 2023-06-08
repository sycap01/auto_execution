package com.ifinfo.api.autotrading.application.dto;

import com.ifinfo.api.infra.common.dto.SearchRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class AutoTradingExecutionRequest extends SearchRequestDto {
    private String bookNo;
    private String marketCategoryCode;
    private String creationStartDate;
    private String creationEndDate;
    private String writingUserNo;
    private String tradingStartCategoryCode;
    private String tradingEndCategoryCode;
    private String startReserveDatetime;
    private String endReserveDatetime;
    private String cancelYn;
}
