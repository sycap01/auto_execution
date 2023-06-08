package com.ifinfo.api.autotrading.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ifinfo.api.autotrading.domain.AutoTradingRules;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "자동트레이딩규칙 등록정보")
public class AutoTradingRuleRegister {

    @Schema(description = "갱신코드(취소후재주문-01/재주문후 취소-02)", defaultValue = "01")

    private String renewalCategoryCode;

    @Schema(description = "자동트레이딩규칙이름", defaultValue = "RULE_01")
    private String tradingRuleName;

    @Schema(description = "매입금액", defaultValue = "10000")
    @Min(value = 0)
    private BigDecimal buyAmount;

    @Schema(description = "매도금액", defaultValue = "10000")
    @Min(value = 0)
    private BigDecimal sellAmount;

    @Schema(description = "매입최소스프레드", defaultValue = "3.30")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal buyMinSpread;

    @Schema(description = "매입최대스프레드", defaultValue = "6.20")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal buyMaxSpread;

    @Schema(description = "매도최소스프레드", defaultValue = "3.30")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal sellMinSpread;

    @Schema(description = "매도최대스프레드", defaultValue = "6.20")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal sellMaxSpread;

    @Schema(description = "갱신주기", defaultValue = "5")
    @DecimalMin(value = "0.00", inclusive = false)
    @Digits(integer = 3, fraction = 2)
    private BigDecimal renewalCycleValue;

    public AutoTradingRules ofEntity() {
        return AutoTradingRules.builder()
                .tradingRuleName(tradingRuleName)
                .renewalCategoryCode(renewalCategoryCode)
                .buyAmount(buyAmount)
                .sellAmount(sellAmount)
                .buyMinSpread(buyMinSpread)
                .buyMaxSpread(buyMaxSpread)
                .sellMinSpread(sellMinSpread)
                .sellMaxSpread(sellMaxSpread)
                .renewalCycleValue(renewalCycleValue)
                .cancelYn("N")
                .build();
    }
}
