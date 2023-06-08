package com.ifinfo.api.autotrading.repository.query;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionResponse;
import org.springframework.data.domain.Page;

public interface AutoTradingExecutionsRepositoryQuery {
    Page<AutoTradingExecutionResponse> searchAutoTradingExecutionList(AutoTradingExecutionRequest request);
}
