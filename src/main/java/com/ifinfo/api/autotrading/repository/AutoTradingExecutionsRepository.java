package com.ifinfo.api.autotrading.repository;

import com.ifinfo.api.autotrading.domain.AutoTradingExecutions;
import com.ifinfo.api.autotrading.repository.query.AutoTradingExecutionsRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoTradingExecutionsRepository extends JpaRepository<AutoTradingExecutions, Long>, AutoTradingExecutionsRepositoryQuery {
}
