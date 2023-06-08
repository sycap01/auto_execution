package com.ifinfo.api.autotrading.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAutoTradingExecutionHistories is a Querydsl query type for AutoTradingExecutionHistories
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAutoTradingExecutionHistories extends EntityPathBase<AutoTradingExecutionHistories> {

    private static final long serialVersionUID = -1284895416L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAutoTradingExecutionHistories autoTradingExecutionHistories = new QAutoTradingExecutionHistories("autoTradingExecutionHistories");

    public final com.ifinfo.api.infra.support.base.QBaseEntity _super = new com.ifinfo.api.infra.support.base.QBaseEntity(this);

    public final QAutoTradingExecutions autoTradingExecution;

    public final StringPath cancelYn = createString("cancelYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final StringPath endDatetime = createString("endDatetime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final StringPath startDatetime = createString("startDatetime");

    public final StringPath statusCategoryCode = createString("statusCategoryCode");

    public QAutoTradingExecutionHistories(String variable) {
        this(AutoTradingExecutionHistories.class, forVariable(variable), INITS);
    }

    public QAutoTradingExecutionHistories(Path<? extends AutoTradingExecutionHistories> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAutoTradingExecutionHistories(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAutoTradingExecutionHistories(PathMetadata metadata, PathInits inits) {
        this(AutoTradingExecutionHistories.class, metadata, inits);
    }

    public QAutoTradingExecutionHistories(Class<? extends AutoTradingExecutionHistories> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.autoTradingExecution = inits.isInitialized("autoTradingExecution") ? new QAutoTradingExecutions(forProperty("autoTradingExecution"), inits.get("autoTradingExecution")) : null;
    }

}

