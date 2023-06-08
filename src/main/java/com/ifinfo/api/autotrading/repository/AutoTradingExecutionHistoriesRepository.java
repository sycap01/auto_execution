package com.ifinfo.api.autotrading.repository;

import com.ifinfo.api.autotrading.domain.AutoTradingExecutionHistories;
import com.ifinfo.api.autotrading.repository.query.AutoTradingExecutionHistoriesRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoTradingExecutionHistoriesRepository extends JpaRepository<AutoTradingExecutionHistories,Long>, AutoTradingExecutionHistoriesRepositoryQuery {
}
