package com.health.partner.utils;

import com.health.partner.api.StatusCode;
import com.health.partner.pojo.payload.Practitioners_Pojo;
import io.qameta.allure.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


/****** Common methods ******/
public class CommonHandler {
    @Step
    public static Practitioners_Pojo getPractitionerBuilder(List<Integer> prcID, int slotLimit, Double lng, Double lat, int appointmentType) {
        return Practitioners_Pojo.builder()
                .practitionerIds(prcID)
                .slotLimit(slotLimit)
                .lng(lng)
                .lat(lat)
                .appointmentType(appointmentType)
                .build();

    }

    @Step
    public static void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }
}
