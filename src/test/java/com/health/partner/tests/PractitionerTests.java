package com.health.partner.tests;

import com.health.partner.api.StatusCode;
import com.health.partner.pojo.payload.Practitioners_Pojo;
import com.health.partner.api.applicationAPI.PractitionerAPI;
import com.health.partner.utils.CommonHandler;
import com.health.partner.utils.DataLoader;
import io.qameta.allure.Description;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.health.partner.api.ProjectConstants.*;
import static com.health.partner.utils.CommonHandler.assertStatusCode;
import static com.health.partner.utils.CommonHandler.getPractitionerBuilder;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Play List")
@Feature("Playlist API")
public class PractitionerTests extends BaseTests {

    //Report generate: allure serve allure-results
// CMD Maven: mvn clean test -DBaseURI=https://webuat1.healthpartners.com
    @Story(" Any Story name")
    @Severity(CRITICAL)
    @Owner("Daljeet Singh Ranot")
    @Link(name = "Website", url = "https://google.com/")
    @Issue("MAR-7422")
    @TmsLink("TMS-1234")
    @Description("This is Schema test")
    @Test(description = "Schema validation for Slots")
    public void shouldBeAbleToValidateSlotsSchema() {
        List<Integer> practitionerIds = new ArrayList<>();
        practitionerIds.add(practitionerId);
        Practitioners_Pojo payload = getPractitionerBuilder(practitionerIds, slotLimit, lng, lat, appointmentType);
        Response response = PractitionerAPI.post(payload, DataLoader.getInstance().getPractitioner_slot_endPoint(), DataLoader.getInstance().getSlot_Schema_Path());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    }


}