package com.spotify.oath2.utils;

import java.util.Properties;

public class DataLoader {

    private final Properties properties;
    private static DataLoader configLoader;

    private DataLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");

    }

    public static DataLoader getInstance() {
        if (configLoader == null) {
            configLoader = new DataLoader();
        }
        return configLoader;
    }

    public String getPlaylist_id() {
        String prop = properties.getProperty("get_playlist_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property get_playlist_id not found in Config.properties file");
        }
    }

    public String getUpdate_playlist_id() {
        String prop = properties.getProperty("update_playlist_id");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property update_playlist_id  not found in Config.properties file");
        }
    }

}
