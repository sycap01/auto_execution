
CREATE TABLE auto_trading_rules
(
    id                                   BIGINT GENERATED ALWAYS AS IDENTITY,        --id
    trading_rule_name                    VARCHAR(200),                               --트레이딩규칙명
    buy_amount                           NUMERIC(30,10),                             --매수금액
    sell_amount                          NUMERIC(30,10),                             --매도금액
    buy_min_spread                       NUMERIC(30,10),                             --매수최소스프레드
    buy_max_spread                       NUMERIC(30,10),                             --매수최대스프레드
    sell_min_spread                      NUMERIC(30,10),                             --매도최소스프레드
    sell_max_spread                      NUMERIC(30,10),                             --매도최대스프레드
    renewal_cycle_value                  NUMERIC(30,10),                             --갱신주기값
    renewal_category_code                VARCHAR(2),                                 --갱신구분코드
    cancel_yn                            VARCHAR(1),                                 --취소여부
    created_by                           VARCHAR(20),
    created_at                           TIMESTAMP,
    last_modified_by                     VARCHAR(20),
    last_modified_at                     TIMESTAMP
);
ALTER TABLE auto_trading_rules ADD CONSTRAINT auto_trading_rules_pk PRIMARY KEY (id);
CREATE INDEX auto_trading_rule_ix1 ON auto_trading_rules (trading_rule_name);

CREATE TABLE auto_trading_executions
(
    id                                   BIGINT GENERATED ALWAYS AS IDENTITY,        --id
    product_id                           BIGINT,                                     --상품id
    book_no                              VARCHAR(20),                                --북번호
    market_category_code                 VARCHAR(2),                                 --거래소구분코드
    creation_date                        VARCHAR(8),                                 --생성년월일
    writing_user_no                      VARCHAR(7),                                 --작성사용자번호
    auto_trading_rule_id                 BIGINT,                                     --자동트레이딩규칙 id
    trading_start_category_code          VARCHAR(2),                                 --트레이딩시작구분코드
    trading_end_category_code            VARCHAR(2),                                 --트레이딩종료구분코드
    start_reserve_datetime               VARCHAR(14),                                --시작예약일시
    end_reserve_datetime                 VARCHAR(14),                                --종료예약일시
    remark_content                       VARCHAR(200),                               --비고내용
    cancel_yn                            VARCHAR(1),                                 --취소여부
    created_by                           VARCHAR(20),
    created_at                           TIMESTAMP,
    last_modified_by                     VARCHAR(20),
    last_modified_at                     TIMESTAMP
);
ALTER TABLE auto_trading_executions ADD CONSTRAINT auto_trading_executions_pk PRIMARY KEY (id);
CREATE INDEX auto_trading_executions_ix1 ON auto_trading_executions (product_id);
CREATE INDEX auto_trading_executions_ix2 ON auto_trading_executions (auto_trading_rule_id);
CREATE INDEX auto_trading_executions_ix3 ON auto_trading_executions (book_no);
CREATE INDEX auto_trading_executions_ix4 ON auto_trading_executions (market_category_code);

CREATE TABLE auto_trading_execution_histories
(
    id                                   BIGINT GENERATED ALWAYS AS IDENTITY,        --id
    auto_trading_execution_id            BIGINT,                                     --자동트레이딩실행id
    status_category_code                 VARCHAR(2),                                 --트레이딩상태구분코드
    start_datetime                       VARCHAR(14),                                --시작일시
    end_datetime                         VARCHAR(14),                                --종료일시
    cancel_yn                            VARCHAR(1),                                 --취소여부
    created_by                           VARCHAR(20),
    created_at                           TIMESTAMP,
    last_modified_by                     VARCHAR(20),
    last_modified_at                     TIMESTAMP
);
ALTER TABLE auto_trading_execution_histories ADD CONSTRAINT auto_trading_execution_histories_pk PRIMARY KEY (id);
CREATE INDEX auto_trading_execution_histories_ix1 ON auto_trading_execution_histories (status_category_code);


