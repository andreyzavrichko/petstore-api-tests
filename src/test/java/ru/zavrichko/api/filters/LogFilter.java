package ru.zavrichko.api.filters;

import io.qameta.allure.restassured.AllureRestAssured;

public class LogFilter {
    private static final AllureRestAssured FILTER = new AllureRestAssured();

    private LogFilter() {
    }

    public static LogFilter logFilter() {
        return InitLogFilter.logFilter;
    }

    public AllureRestAssured withCustomTemplates() {
        FILTER.setRequestTemplate("request.ftl");
        FILTER.setResponseTemplate("response.ftl");
        return FILTER;

    }

    private static class InitLogFilter {
        private static final LogFilter logFilter = new LogFilter();
    }
}