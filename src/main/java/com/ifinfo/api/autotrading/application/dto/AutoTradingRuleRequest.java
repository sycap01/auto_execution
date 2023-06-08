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
public class AutoTradingRuleRequest extends SearchRequestDto {
    private String cancelYn;
    private String renewalCategoryCode;
    private String tradingRuleName;

}
