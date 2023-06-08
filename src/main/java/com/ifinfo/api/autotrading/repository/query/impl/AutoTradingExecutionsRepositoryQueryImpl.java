package com.ifinfo.api.autotrading.repository.query.impl;

import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionRequest;
import com.ifinfo.api.autotrading.application.dto.AutoTradingExecutionResponse;
import com.ifinfo.api.autotrading.repository.query.AutoTradingExecutionsRepositoryQuery;
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

import static com.ifinfo.api.autotrading.domain.QAutoTradingExecutionHistories.autoTradingExecutionHistories;
import static com.ifinfo.api.autotrading.domain.QAutoTradingExecutions.autoTradingExecutions;

@Repository
@RequiredArgsConstructor
public class AutoTradingExecutionsRepositoryQueryImpl implements AutoTradingExecutionsRepositoryQuery {
    private final JPAQueryFactory queryFactory;

    @Override
    public Page<AutoTradingExecutionResponse> searchAutoTradingExecutionList(AutoTradingExecutionRequest input) {

        int page = input.getPageIndex() - 1;
        int pageSize = input.getPageRow();
        Pageable pageable = PageRequest.of(page, pageSize);

        List<AutoTradingExecutionResponse> list = queryFactory
                .select(Projections.fields(AutoTradingExecutionResponse.class,
                        autoTradingExecutions.id,
                        autoTradingExecutions.productId,
                        autoTradingExecutions.bookNo,
                        autoTradingExecutions.marketCategoryCode,
                        autoTradingExecutions.creationDate,
                        autoTradingExecutions.writingUserNo,
                        autoTradingExecutions.tradingEndCategoryCode,
                        autoTradingExecutions.tradingEndCategoryCode,
                        autoTradingExecutions.startReserveDatetime,
                        autoTradingExecutions.endReserveDatetime,
                        autoTradingExecutions.remarkContent,
                        autoTradingExecutions.cancelYn))
                .from(autoTradingExecutions)
                .innerJoin(autoTradingExecutions.autoTradingExecutionHistories, autoTradingExecutionHistories)
                .where(
                        autoTradingExecutions.creationDate.goe(input.getCreationStartDate()),
                        autoTradingExecutions.creationDate.loe(input.getCreationEndDate()),
                        _cancelYnEq(input.getCancelYn()),
                        _bookNoContains(input.getBookNo()),
                        _writingUserNoContains(input.getWritingUserNo()),
                        _marketCategoryCodeEq(input.getMarketCategoryCode()),
                        _tradingStartCategoryCodeEq(input.getTradingStartCategoryCode()),
                        _tradingEndCategoryCodeEq(input.getTradingEndCategoryCode()),
                        _startReserveDatetimeEq(input.getStartReserveDatetime()),
                        _endReserveDatetimeEq(input.getEndReserveDatetime())
                )
                .orderBy(autoTradingExecutions.id.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(autoTradingExecutions.count())
                .from(autoTradingExecutions)
                .innerJoin(autoTradingExecutions.autoTradingExecutionHistories, autoTradingExecutionHistories)
                .where(
                        autoTradingExecutions.creationDate.goe(input.getCreationStartDate()),
                        autoTradingExecutions.creationDate.loe(input.getCreationEndDate()),
                        _cancelYnEq(input.getCancelYn()),
                        _bookNoContains(input.getBookNo()),
                        _writingUserNoContains(input.getWritingUserNo()),
                        _marketCategoryCodeEq(input.getMarketCategoryCode()),
                        _tradingStartCategoryCodeEq(input.getTradingStartCategoryCode()),
                        _tradingEndCategoryCodeEq(input.getTradingEndCategoryCode()),
                        _startReserveDatetimeEq(input.getStartReserveDatetime()),
                        _endReserveDatetimeEq(input.getEndReserveDatetime())
                )
                .fetchOne();

        return new PageImpl<>(list, pageable, total);
    }

    private BooleanExpression _cancelYnEq(String cancelYn) {

        return StringUtils.hasText(cancelYn) ? autoTradingExecutions.cancelYn.eq(cancelYn) : null;
    }

    private BooleanExpression _bookNoContains(String bookNo) {

        return StringUtils.hasText(bookNo) ? autoTradingExecutions.bookNo.contains(bookNo) : null;
    }

    private BooleanExpression _writingUserNoContains(String writingUserNo) {

        return StringUtils.hasText(writingUserNo) ? autoTradingExecutions.writingUserNo.contains(writingUserNo) : null;
    }

    private BooleanExpression _marketCategoryCodeEq(String marketCategoryCode) {

        return StringUtils.hasText(marketCategoryCode) ? autoTradingExecutions.marketCategoryCode.eq(marketCategoryCode) : null;
    }

    private BooleanExpression _tradingStartCategoryCodeEq(String tradingStartCategoryCode) {

        return StringUtils.hasText(tradingStartCategoryCode) ? autoTradingExecutions.tradingStartCategoryCode.eq(tradingStartCategoryCode) : null;
    }

    private BooleanExpression _tradingEndCategoryCodeEq(String tradingEndCategoryCode) {

        return StringUtils.hasText(tradingEndCategoryCode) ? autoTradingExecutions.tradingEndCategoryCode.eq(tradingEndCategoryCode) : null;
    }

    private BooleanExpression _startReserveDatetimeEq(String startReserveDatetime) {

        return StringUtils.hasText(startReserveDatetime) ? autoTradingExecutions.startReserveDatetime.eq(startReserveDatetime) : null;
    }

    private BooleanExpression _endReserveDatetimeEq(String endReserveDatetime) {

        return StringUtils.hasText(endReserveDatetime) ? autoTradingExecutions.endReserveDatetime.eq(endReserveDatetime) : null;
    }
}
