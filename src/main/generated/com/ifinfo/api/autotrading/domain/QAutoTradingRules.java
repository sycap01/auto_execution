package com.ifinfo.api.autotrading.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAutoTradingRules is a Querydsl query type for AutoTradingRules
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAutoTradingRules extends EntityPathBase<AutoTradingRules> {

    private static final long serialVersionUID = -747068183L;

    public static final QAutoTradingRules autoTradingRules = new QAutoTradingRules("autoTradingRules");

    public final com.ifinfo.api.infra.support.base.QBaseEntity _super = new com.ifinfo.api.infra.support.base.QBaseEntity(this);

    public final SetPath<AutoTradingExecutions, QAutoTradingExecutions> autoTradingExecutions = this.<AutoTradingExecutions, QAutoTradingExecutions>createSet("autoTradingExecutions", AutoTradingExecutions.class, QAutoTradingExecutions.class, PathInits.DIRECT2);

    public final NumberPath<java.math.BigDecimal> buyAmount = createNumber("buyAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> buyMaxSpread = createNumber("buyMaxSpread", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> buyMinSpread = createNumber("buyMinSpread", java.math.BigDecimal.class);

    public final StringPath cancelYn = createString("cancelYn");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final StringPath createdBy = _super.createdBy;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedAt = _super.lastModifiedAt;

    //inherited
    public final StringPath lastModifiedBy = _super.lastModifiedBy;

    public final StringPath renewalCategoryCode = createString("renewalCategoryCode");

    public final NumberPath<java.math.BigDecimal> renewalCycleValue = createNumber("renewalCycleValue", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> sellAmount = createNumber("sellAmount", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> sellMaxSpread = createNumber("sellMaxSpread", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> sellMinSpread = createNumber("sellMinSpread", java.math.BigDecimal.class);

    public final StringPath tradingRuleName = createString("tradingRuleName");

    public QAutoTradingRules(String variable) {
        super(AutoTradingRules.class, forVariable(variable));
    }

    public QAutoTradingRules(Path<? extends AutoTradingRules> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAutoTradingRules(PathMetadata metadata) {
        super(AutoTradingRules.class, metadata);
    }

}

