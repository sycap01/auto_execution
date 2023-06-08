package com.ifinfo.api.autotrading.application.service;

import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleModify;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRegister;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleResponse;
import com.ifinfo.api.autotrading.domain.AutoTradingRules;
import com.ifinfo.api.autotrading.repository.AutoTradingRulesRepository;
import com.ifinfo.api.infra.support.exception.ApiException;
import com.ifinfo.api.infra.support.exception.ErrorInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AutoTradingRulesService {
    private final AutoTradingRulesRepository repository;

    @Transactional(readOnly = true)
    public Page<AutoTradingRuleResponse> list(AutoTradingRuleRequest request) {
        return repository.searchAutoTradingRuleList(request);
    }

    @Transactional(readOnly = true)
    public AutoTradingRules detail(Long id) {
        AutoTradingRules autoTradingRules = repository.findById(id).get();
        if (autoTradingRules.isDeleted()) {
            throw new ApiException(ErrorInfo.ERROR_0001, "사용할 수 없는 규칙 입니다.");
        }
        return autoTradingRules;
    }

    @Transactional(readOnly = true)
    public AutoTradingRuleResponse detailResponse(Long id) {
        return detail(id).ofDetailResponse();
    }
    @Transactional
    public AutoTradingRuleResponse register(AutoTradingRuleRegister input) {
        AutoTradingRules autoTradingRule = input.ofEntity();
        autoTradingRule.register();
        return repository.save(autoTradingRule).ofResponse();
    }

    @Transactional
    public AutoTradingRuleResponse modify(Long id, AutoTradingRuleModify input) {
        AutoTradingRules autoTradingRules = detail(id);
        autoTradingRules.modify(input);
        return autoTradingRules.ofResponse();
    }

    @Transactional
    public void delete(Long id) {
        AutoTradingRules autoTradingRule = detail(id);
        autoTradingRule.delete();
    }
}
