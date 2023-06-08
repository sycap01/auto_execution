package com.ifinfo.api.autotrading.repository;

import com.ifinfo.api.autotrading.domain.AutoTradingRules;
import com.ifinfo.api.autotrading.repository.query.AutoTradingRulesRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoTradingRulesRepository extends JpaRepository<AutoTradingRules,Long>, AutoTradingRulesRepositoryQuery {
}
