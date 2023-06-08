package com.ifinfo.api.autotrading.repository.query;

import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleResponse;
import org.springframework.data.domain.Page;

public interface AutoTradingRulesRepositoryQuery {
    Page<AutoTradingRuleResponse> searchAutoTradingRuleList(AutoTradingRuleRequest request);
}
