package com.ifinfo.api.autotrading.repository.query.impl;

import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingRuleResponse;
import com.ifinfo.api.autotrading.repository.query.AutoTradingRulesRepositoryQuery;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.ifinfo.api.autotrading.domain.QAutoTradingRules.autoTradingRules;

@RequiredArgsConstructor
@Repository
public class AutoTradingRulesRepositoryQueryImpl implements AutoTradingRulesRepositoryQuery {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<AutoTradingRuleResponse> searchAutoTradingRuleList(AutoTradingRuleRequest input) {

        int page = input.getPageIndex() - 1;
        int pageSize = input.getPageRow();
        Pageable pageable = PageRequest.of(page, pageSize);

        List<AutoTradingRuleResponse> list = queryFactory
                .select(Projections.fields(AutoTradingRuleResponse.class,
                        autoTradingRules.id,
                        autoTradingRules.tradingRuleName,
                        autoTradingRules.buyAmount,
                        autoTradingRules.sellAmount,
                        autoTradingRules.buyMinSpread,
                        autoTradingRules.buyMaxSpread,
                        autoTradingRules.sellMinSpread,
                        autoTradingRules.sellMaxSpread,
                        autoTradingRules.renewalCycleValue,
                        autoTradingRules.renewalCategoryCode
                        ))
                .from(autoTradingRules)
                .where(
                        _renewalCategoryCodeEq(input.getRenewalCategoryCode()),
                        _cancelYnEq(input.getCancelYn()),
                        _tradingRuleNameContains(input.getTradingRuleName())
                )
                .orderBy(autoTradingRules.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(autoTradingRules.count())
                .from(autoTradingRules)
                .where(
                        _renewalCategoryCodeEq(input.getRenewalCategoryCode()),
                        _cancelYnEq(input.getCancelYn()),
                        _tradingRuleNameContains(input.getTradingRuleName())
                )
                .fetchOne();

        return new PageImpl<>(list, pageable, total);
    }


    private BooleanExpression _tradingRuleNameContains(String tradingRuleName) {
        return StringUtils.hasText(tradingRuleName) ? autoTradingRules.tradingRuleName.contains(tradingRuleName) : null;
    }

    private BooleanExpression _renewalCategoryCodeEq(String renewalCategoryCode) {
        return StringUtils.hasText(renewalCategoryCode) ? autoTradingRules.renewalCategoryCode.eq(renewalCategoryCode) : null;
    }

    private BooleanExpression _cancelYnEq(String cancelYn) {
        return StringUtils.hasText(cancelYn) ? autoTradingRules.cancelYn.eq(cancelYn) : null;
    }
}
