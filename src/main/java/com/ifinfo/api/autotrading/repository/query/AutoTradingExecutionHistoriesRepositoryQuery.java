package com.ifinfo.api.autotrading.repository.query;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionHistoryResponse;
import org.springframework.data.domain.Page;

public interface AutoTradingExecutionHistoriesRepositoryQuery {
    Page<AutoTradingExecutionHistoryResponse> searchAutoTradingExecutionHistoryList(AutoTradingExecutionHistoryRequest request);
}
