package com.test.managecontacts.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class LoggingConfig {

    @Bean
    public CommonsRequestLoggingFilter
    logFilter() {
        CommonsRequestLoggingFilter filterLog = new CommonsRequestLoggingFilter();
        filterLog.setIncludeQueryString(true);
        filterLog.setIncludePayload(true);
        filterLog.setMaxPayloadLength(15000);
        filterLog.setIncludeHeaders(false);
        filterLog.setAfterMessagePrefix("Request : ");
        return filterLog;
    }
}
