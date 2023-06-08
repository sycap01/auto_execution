package com.ifinfo.api.autotrading.application.controller;

import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRegister;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleResponse;
import com.ifinfo.api.autotrading.application.service.AutoTradingRulesService;
import com.ifinfo.api.infra.support.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/auto-rule")
@RequiredArgsConstructor
@RestController
public class AutoTradingRulesController {

    private final AutoTradingRulesService autoTradingRulesService;

    @GetMapping(path = "/inquiry")
    public ResponseEntity<ApiResponse<Page<AutoTradingRuleResponse>>> list(AutoTradingRuleRequest request) {
        Page<AutoTradingRuleResponse> output = autoTradingRulesService.list(request);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @GetMapping(path = "/inquiry/{id}")
    public ResponseEntity<ApiResponse<AutoTradingRuleResponse>> detail(@PathVariable(value = "id") Long id) {
        AutoTradingRuleResponse output = autoTradingRulesService.detailResponse(id);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @PostMapping(path = "/register")
    public ResponseEntity<ApiResponse<AutoTradingRuleResponse>> register(@RequestBody @Valid AutoTradingRuleRegister input) {
        AutoTradingRuleResponse output = autoTradingRulesService.register(input);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }

    @PostMapping(path = "/modify/{id}")
    public ResponseEntity<ApiResponse<AutoTradingRuleResponse>> modify(@PathVariable(value = "id") Long id, @RequestBody @Valid AutoTradingRuleModify input) {
        AutoTradingRuleResponse output = autoTradingRulesService.modify(id, input);
        return new ResponseEntity<>(ApiResponse.success(output), HttpStatus.OK);
    }


    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable(value = "id") Long id) {
        autoTradingRulesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
