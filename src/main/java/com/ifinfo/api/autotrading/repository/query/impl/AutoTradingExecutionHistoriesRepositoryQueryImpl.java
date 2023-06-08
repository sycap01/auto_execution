package com.ifinfo.api.autotrading.repository.query.impl;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryResponse;
import com.ifinfo.api.autotrading.repository.query.AutoTradingExecutionHistoriesRepositoryQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class AutoTradingExecutionHistoriesRepositoryQueryImpl implements AutoTradingExecutionHistoriesRepositoryQuery {
    @Override
    public Page<AutoTradingExecutionHistoryResponse> searchAutoTradingExecutionHistoryList(AutoTradingExecutionHistoryRequest request) {
        return null;
    }
}
