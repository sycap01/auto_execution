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
public class AutoTradingExecutionModify {

    @Schema(description = "북번호", defaultValue = "CRIPTO_01")
    private String bookNo;

    @Schema(description = "트레이딩마켓구분코드", defaultValue = "01")
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
}
