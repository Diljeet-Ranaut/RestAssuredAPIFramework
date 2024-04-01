package com.health.partner.utils;

import com.github.javafaker.Faker;

public class FakerUtils {
    public static String generateNames() {
        Faker faker = new Faker();
       return "Name "+ faker.regexify("[A-Za-z0-9 ,-_]{20}");
    }
    public static String generateDescription() {
        Faker faker = new Faker();
        return "Description "+ faker.regexify("[A-Za-z0-9 ,-_@#&/]{50}");
    }
}