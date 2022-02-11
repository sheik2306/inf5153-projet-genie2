package com.inf5153.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SQLDialectTest {

    public SQLDialect sql = new SQLDialect();


    @Test
    void supportsLimit() {
    }

    @Test
    void getLimitString() {
    }

    @Test
    void supportsCurrentTimestampSelection() {

        Assertions.assertEquals(true,sql.supportsCurrentTimestampSelection());
    }

    @Test
    void isCurrentTimestampSelectStringCallable() {
        Assertions.assertEquals(false,sql.isCurrentTimestampSelectStringCallable());

    }

    @Test
    void getCurrentTimestampSelectString() {
        Assertions.assertEquals("select current_timestamp",sql.getCurrentTimestampSelectString());
    }

    @Test
    void supportsUnionAll() {
        Assertions.assertEquals(true,sql.supportsUnionAll());

    }

    @Test
    void hasAlterTable() {
        Assertions.assertEquals(false,sql.hasAlterTable());

    }

    @Test
    void dropConstraints() {
        Assertions.assertEquals(false,sql.dropConstraints());

    }

    @Test
    void getAddColumnString() {
        Assertions.assertEquals("add column",sql.getAddColumnString());

    }

    @Test
    void getForUpdateString() {
        Assertions.assertEquals("",sql.getForUpdateString());

    }

    @Test
    void supportsOuterJoinForUpdate() {
        Assertions.assertEquals(false,sql.supportsOuterJoinForUpdate());

    }



    @Test
    void supportsIfExistsBeforeTableName() {
        Assertions.assertEquals(true,sql.supportsIfExistsBeforeTableName());

    }

    @Test
    void supportsCascadeDelete() {
        Assertions.assertEquals(false,sql.supportsCascadeDelete());

    }
}