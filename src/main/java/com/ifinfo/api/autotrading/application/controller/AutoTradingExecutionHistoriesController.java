package com.ifinfo.api.autotrading.application.controller;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryResponse;
import com.ifinfo.api.autotrading.application.service.AutoTradingExecutionHistoryService;
import com.ifinfo.api.infra.support.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/auto-execution-history")
@RequiredArgsConstructor
@RestController
public class AutoTradingExecutionHistoriesController {

    private final AutoTradingExecutionHistoryService autoTradingExecutionHistoriesService;

    @GetMapping(path = "/inquiry")
    public ResponseEntity<ApiResponse<Page<AutoTradingExecutionHistoryResponse>>> list(AutoTradingExecutionHistoryRequest request) {
        Page<AutoTradingExecutionHistoryResponse> output = autoTradingExecutionHistoriesService.list(request);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @GetMapping(path = "/inquiry/{id}")
    public ResponseEntity<ApiResponse<AutoTradingExecutionHistoryResponse>> detail(@PathVariable(value = "id") Long id) {
        AutoTradingExecutionHistoryResponse output = autoTradingExecutionHistoriesService.detailResponse(id);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }


    @PostMapping(path = "/modify/{id}")
    public ResponseEntity<ApiResponse<AutoTradingExecutionHistoryResponse>> modify(@PathVariable(value = "id") Long id, @RequestBody @Valid AutoTradingExecutionHistoryModify input) {
        AutoTradingExecutionHistoryResponse output = autoTradingExecutionHistoriesService.modify(id, input);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }


}
