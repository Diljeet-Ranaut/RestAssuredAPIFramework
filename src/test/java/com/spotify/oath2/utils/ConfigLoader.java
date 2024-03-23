package com.spotify.oath2.utils;

import java.util.Properties;

public class ConfigLoader {

    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/Config.properties");

    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getClientID() {
        String prop = properties.getProperty("client_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property Client id not found in Config.properties file");
        }
    }

    public String getGrant_type() {
        String prop = properties.getProperty("grant_type");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property grant_type  not found in Config.properties file");
        }
    }

    public String getRefresh_token() {
        String prop = properties.getProperty("refresh_token");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property refresh_token not found in Config.properties file");
        }
    }

    public String getClientIDSecret() {
        String prop = properties.getProperty("clientIDSecret");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property clientIDSecret not found in Config.properties file");
        }
    }

    public String getUser_id() {
        String prop = properties.getProperty("user_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property user_id not found in Config.properties file");
        }
    }
}
