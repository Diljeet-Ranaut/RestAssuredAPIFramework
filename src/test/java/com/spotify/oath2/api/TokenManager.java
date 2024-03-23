package com.spotify.oath2.api;

import com.spotify.oath2.utils.ConfigLoader;
import io.restassured.response.Response;

import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;

import static com.spotify.oath2.api.RestResources.postAccount;

public class TokenManager {
    private static String access_token;
    private static Instant expiry_time;

    public synchronized static String getToken() {

        try {
            if (access_token == null || Instant.now().isAfter(expiry_time)) {
                System.out.println("Renewing toekn ......");
                Response response = renewToken();
                access_token = response.path("access_token");
                int expiryDurationInSec = response.path("expires_in");
                expiry_time = Instant.now().plusSeconds(expiryDurationInSec);
            } else {
                System.out.println("Token is good to use...");
            }
        } catch (Exception e) {
            throw new RuntimeException("ABORT!!! Failed to get token");
        }
        return access_token;

    }


    private static Response renewToken() {

        String clientIDSecret = ConfigLoader.getInstance().getClientIDSecret();
        String userColonPassword = "96292c025346c2b934f322f5f8aa1108:bd32ee100c1f487087688ed5b1054a7a";
        String base64Encoded = Base64.getEncoder().encodeToString(userColonPassword.getBytes());
        // System.out.println("Encoded String : " + base64Encoded);
        //OTYyOTA4MmMwMjUzNDZjMmI5MzRmMzIyZjVmOGFhMTE6YmQzMmVlMTAwYzFmNDg3MDg3Njg4ZWQ1YjEwNTRhN2E=
        HashMap<String, String> formParam = new HashMap<>();
        formParam.put("client_id", ConfigLoader.getInstance().getClientID());
        formParam.put("grant_type", ConfigLoader.getInstance().getGrant_type());
        formParam.put("refresh_token", ConfigLoader.getInstance().getRefresh_token());

        Response response = RestResources.postAccount(formParam, clientIDSecret);
        if (response.statusCode() != 200) {

            throw new RuntimeException("Abort!!! Renew Token Failed!");
        } else {
            return response;
        }
    }
}
