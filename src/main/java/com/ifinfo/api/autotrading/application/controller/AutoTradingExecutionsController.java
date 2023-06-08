package com.ifinfo.api.autotrading.application.controller;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionRegister;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionResponse;
import com.ifinfo.api.autotrading.application.service.AutoTradingExecutionsService;
import com.ifinfo.api.infra.support.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/auto-execution")
@RequiredArgsConstructor
@RestController
public class AutoTradingExecutionsController {

    private final AutoTradingExecutionsService autoTradingExecutionsService;

    @GetMapping(path = "/inquiry")
    public ResponseEntity<ApiResponse<Page<AutoTradingExecutionResponse>>> list(AutoTradingExecutionRequest request) {
        Page<AutoTradingExecutionResponse> output = autoTradingExecutionsService.list(request);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @GetMapping(path = "/inquiry/{id}")
    public ResponseEntity<ApiResponse<AutoTradingExecutionResponse>> detail(@PathVariable(value = "id") Long id) {
        AutoTradingExecutionResponse output = autoTradingExecutionsService.detailResponse(id);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse<AutoTradingExecutionResponse>> register(@RequestBody @Valid AutoTradingExecutionRegister input) {
        AutoTradingExecutionResponse output = autoTradingExecutionsService.register(input);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @PostMapping(path = "/modify/{id}")
    public ResponseEntity<ApiResponse<AutoTradingExecutionResponse>> modify(@PathVariable(value = "id") Long id, @RequestBody @Valid AutoTradingExecutionModify input) {
        AutoTradingExecutionResponse output = autoTradingExecutionsService.modify(id, input);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }


    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable(value = "id") Long id) {
        autoTradingExecutionsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
