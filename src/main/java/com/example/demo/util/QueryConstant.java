package com.example.demo.util;

public interface QueryConstant {

     String GET_USER_ID_FROM_ADHAR_ID = "\n" +
            "SELECT DISTINCT\n" +
            "    UserId\n" +
            "FROM DipAllotment\n" +
            "WHERE CreatedAt >= DATE_FORMAT(\n" +
            "                      DATE_SUB(CURRENT_DATE, INTERVAL 5 MONTH),\n" +
            "                      '%Y-%m-01'\n" +
            "                  )\n" +
            "  AND CreatedAt <  DATE_FORMAT(\n" +
            "                      CURRENT_DATE,\n" +
            "                      '%Y-%m-01'\n" +
            "                  )\n" +
            "  AND AadharCard = :aadharId\n" +
            "ORDER BY UserId ASC;";
}
