package com.ifinfo.api.autotrading.application.service;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryRegister;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryResponse;
import com.ifinfo.api.autotrading.domain.AutoTradingExecutionHistories;
import com.ifinfo.api.autotrading.repository.AutoTradingExecutionHistoriesRepository;
import com.ifinfo.api.infra.support.exception.ApiException;
import com.ifinfo.api.infra.support.exception.ErrorInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AutoTradingExecutionHistoryService {
    private final AutoTradingExecutionHistoriesRepository repository;

    @Transactional(readOnly = true)
    public Page<AutoTradingExecutionHistoryResponse> list(AutoTradingExecutionHistoryRequest request) {
        return repository.searchAutoTradingExecutionHistoryList(request);
    }

    @Transactional(readOnly = true)
    public AutoTradingExecutionHistories detail(Long id) {
        AutoTradingExecutionHistories autoTradingExecutionHistories = repository.getReferenceById(id);

        if (autoTradingExecutionHistories.isDeleted()) {
            throw new ApiException(ErrorInfo.ERROR_0001, "사용할 수 없는 이력 입니다.");
        }
        return autoTradingExecutionHistories;
    }

    @Transactional(readOnly = true)
    public AutoTradingExecutionHistoryResponse detailResponse(Long id) {
        return detail(id).ofDetailResponse();
    }
    @Transactional
    public AutoTradingExecutionHistoryResponse register(AutoTradingExecutionHistoryRegister input) {
        AutoTradingExecutionHistories autoTradingExecutionHistory = input.ofEntity();
        autoTradingExecutionHistory.register();
        return repository.save(autoTradingExecutionHistory).ofDetailResponse();
    }

    @Transactional
    public AutoTradingExecutionHistoryResponse modify(Long id, AutoTradingExecutionHistoryModify input) {
        AutoTradingExecutionHistories autoTradingExecutionHistory = detail(id);
        autoTradingExecutionHistory.modify(input);
        return autoTradingExecutionHistory.ofDetailResponse();
    }

    @Transactional
    public void delete(Long id) {
        AutoTradingExecutionHistories autoTradingExecutionHistory = detail(id);
        autoTradingExecutionHistory.delete();
    }
}
