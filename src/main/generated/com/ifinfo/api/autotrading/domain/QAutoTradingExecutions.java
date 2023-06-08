package com.ifinfo.api.autotrading.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAutoTradingExecutions is a Querydsl query type for AutoTradingExecutions
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAutoTradingExecutions extends EntityPathBase<AutoTradingExecutions> {

    private static final long serialVersionUID = 503489449L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAutoTradingExecutions autoTradingExecutions = new QAutoTradingExecutions("autoTradingExecutions");

    public final com.ifinfo.api.infra.support.base.QBaseEntity _super = new com.ifinfo.api.infra.support.base.QBaseEntity(this);

    public final SetPath<AutoTradingExecutionHistories, QAutoTradingExecutionHistories> autoTradingExecutionHistories = this.<AutoTradingExecutionHistories, QAutoTradingExecutionHistories>createSet("autoTradingExecutionHistories", AutoTradingExecutionHistories.class, QAutoTradingExecutionHistories.class, PathInits.DIRECT2);

    public final QAutoTradingRules autoTradingRule;

    public final StringPath bookNo = createString("bookNo");

    public final StringPath cancelYn = createString("cancelYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath creationDate = createString("creationDate");

    public final StringPath endReserveDatetime = createString("endReserveDatetime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final StringPath marketCategoryCode = createString("marketCategoryCode");

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final StringPath remarkContent = createString("remarkContent");

    public final StringPath startReserveDatetime = createString("startReserveDatetime");

    public final StringPath tradingEndCategoryCode = createString("tradingEndCategoryCode");

    public final StringPath tradingStartCategoryCode = createString("tradingStartCategoryCode");

    public final StringPath writingUserNo = createString("writingUserNo");

    public QAutoTradingExecutions(String variable) {
        this(AutoTradingExecutions.class, forVariable(variable), INITS);
    }

    public QAutoTradingExecutions(Path<? extends AutoTradingExecutions> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAutoTradingExecutions(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAutoTradingExecutions(PathMetadata metadata, PathInits inits) {
        this(AutoTradingExecutions.class, metadata, inits);
    }

    public QAutoTradingExecutions(Class<? extends AutoTradingExecutions> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.autoTradingRule = inits.isInitialized("autoTradingRule") ? new QAutoTradingRules(forProperty("autoTradingRule")) : null;
    }

}

