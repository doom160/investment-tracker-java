package com.renfa.helper;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "statistics")
public class StatisticsHelper {

    private static int emaShort;
    private static int emaLong;
    private static int emaSmoothing;
    private static int rsiEmaShort;
    private static int rsiEmaLong;
    private static int rsiEmaSmoothing;

    public static int getValue() {
        return emaShort;
    }


}

