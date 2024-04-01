package com.health.partner.api.applicationAPI;

import com.health.partner.api.RestResources;
import com.health.partner.pojo.payload.Practitioners_Pojo;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PractitionerAPI {

    @Step
    public static Response post(Practitioners_Pojo prc, String endpoint, String schemaFilePath) {
        return RestResources.postPrc(endpoint, prc, schemaFilePath);
    }

}
