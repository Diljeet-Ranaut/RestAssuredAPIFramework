package com.health.partner.utils;

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

    public String getPractitioner_slot_endPoint() {
        String prop = properties.getProperty("practitioner_slot_endPoint");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property practitioner_slot_endPoint  not found in Config.properties file");
        }
    }

    public String getSlot_Schema_Path() {
        String prop = properties.getProperty("Slot_Schema_Path");
        if (prop != null) {
            return prop;
        } else {
            throw new RuntimeException("Property Slot_Schema_Path  not found in Config.properties file");
        }
    }
}
