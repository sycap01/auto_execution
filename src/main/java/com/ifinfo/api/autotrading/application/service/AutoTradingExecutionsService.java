package com.ifinfo.api.autotrading.application.service;

import com.ifinfo.api.autotrading.application.dto.*;
import com.ifinfo.api.autotrading.domain.AutoTradingExecutions;
import com.ifinfo.api.autotrading.repository.AutoTradingExecutionsRepository;
import com.ifinfo.api.infra.support.exception.ApiException;
import com.ifinfo.api.infra.support.exception.ErrorInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AutoTradingExecutionsService {
    private final AutoTradingExecutionsRepository repository;
    private final AutoTradingExecutionHistoryService autoTradingExecutionHistoryService;
    private final AutoTradingRulesService autoTradingRulesService;

    @Transactional(readOnly = true)
    public Page<AutoTradingExecutionResponse> list(AutoTradingExecutionRequest request) {
        return repository.searchAutoTradingExecutionList(request);
    }

    @Transactional(readOnly = true)
    public AutoTradingExecutions detail(Long id) {
        AutoTradingExecutions autoTradingExecutions = repository.getReferenceById(id);

        if (autoTradingExecutions.isDeleted()) {
            throw new ApiException(ErrorInfo.ERROR_0001, "사용할 수 없는 실행 입니다.");
        }
        return autoTradingExecutions;
    }

    @Transactional(readOnly = true)
    public AutoTradingExecutionResponse detailResponse(Long id) {
        return detail(id).ofDetailResponse();
    }

    @Transactional
    public AutoTradingExecutionResponse register(AutoTradingExecutionRegister input) {
        AutoTradingExecutions autoTradingExecution = input.ofEntity();
        autoTradingExecution.setAutoTradingRule(autoTradingRulesService.detail(input.getAutoTradingRuleId()));
        autoTradingExecution.register();
        return repository.save(autoTradingExecution).ofDetailResponse();
    }

    @Transactional
    public AutoTradingExecutionResponse modify(Long id, AutoTradingExecutionModify input) {
        AutoTradingExecutions autoTradingExecutions = detail(id);
        autoTradingExecutions.modify(input);
        return autoTradingExecutions.ofDetailResponse();
    }

    @Transactional
    public void delete(Long id) {
        AutoTradingExecutions autoTradingExecution = detail(id);
        autoTradingExecution.delete();
    }


}
