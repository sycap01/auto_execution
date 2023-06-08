package com.ifinfo.api.autotrading.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.ifinfo.api.autotrading.domain.AutoTradingExecutions;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Schema(description = "자동트레이딩실행 등록정보")
public class AutoTradingExecutionRegister {

    @Schema(description = "북번호", defaultValue = "CRIPTO_01")
    private String bookNo;

    @Schema(description = "트레이딩대상구분코드", defaultValue = "01")
    private String marketCategoryCode;

    @Schema(description = "작성사용자번호", defaultValue = "01")
    private String writingUserNo;

    @Schema(description = "자동트레이딩규칙 ID", defaultValue = "1")
    private Long autoTradingRuleId;

    @Schema(description = "상품 ID", defaultValue = "46")
    private Long productId;

    @Schema(description = "트레이딩시작구분코드", defaultValue = "01")
    private String tradingStartCategoryCode;

    @Schema(description = "트레이딩종료구분코드", defaultValue = "01")
    private String tradingEndCategoryCode;

    @Schema(description = "시작예약일시", defaultValue = "")
    private String startReserveDatetime;

    @Schema(description = "종료예약일시", defaultValue = "")
    private String endReserveDatetime;

    @Schema(description = "비고내용", defaultValue = "")
    private String remarkContent;

    public AutoTradingExecutions ofEntity() {
        return AutoTradingExecutions.builder()
                .bookNo(bookNo)
                .marketCategoryCode(marketCategoryCode)
                .writingUserNo(writingUserNo)
                .tradingStartCategoryCode(tradingStartCategoryCode)
                .tradingEndCategoryCode(tradingEndCategoryCode)
                .startReserveDatetime(startReserveDatetime)
                .endReserveDatetime(endReserveDatetime)
                .remarkContent(remarkContent)
                .productId(productId)
                .creationDate(String.valueOf(LocalDate.now()).replaceAll("-", ""))
                .cancelYn("N")
                .build();
    }
}
