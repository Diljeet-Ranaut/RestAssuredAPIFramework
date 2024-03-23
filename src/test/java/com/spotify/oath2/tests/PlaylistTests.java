package com.spotify.oath2.tests;

import com.spotify.oath2.api.StatusCode;
import com.spotify.oath2.api.applicationAPI.PlaylistAPI;
import com.spotify.oath2.pojo.ErrorRoot;
import com.spotify.oath2.pojo.Playlist;
import com.spotify.oath2.utils.DataLoader;
import io.qameta.allure.Description;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.spotify.oath2.api.StatusCode.*;
import static com.spotify.oath2.utils.FakerUtils.generateDescription;
import static com.spotify.oath2.utils.FakerUtils.generateNames;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Epic("Play List")
@Feature("Playlist API")
public class PlaylistTests extends BaseTests{
    //allure serve allure-results - report genrate
    //https://allurereport.org/docs/testng/
    @Story("Create Playlist APIs")
    @Severity(CRITICAL)
    @Owner("Daljeet Singh Ranot")
    @Link(name = "Website", url = "https://google.com/")
    @Issue("MAR-7422")
    @TmsLink("TMS-1234")
    @Description("This is discription bro")
    @Test(description = "Creat Playlist API")
    public void shouldBeAbleToCreatePlayList() {
        Playlist playlist = playlistBuilder(generateNames(), generateDescription(), false);
        Response response = PlaylistAPI.post(playlist);
        assertStatusCode(response.getStatusCode(), CODE_201);
        assertEquals(response.as(Playlist.class), playlist);

    }

    @Test
    public void shouldBeAbleToGetPlayList() {
        Playlist playlist = getplaylistBuilder(generateNames(), generateDescription(), "playlist");
        Response response = PlaylistAPI.get(DataLoader.getInstance().getPlaylist_id());
        System.out.println(" Check Response:" + response.statusCode());
       // assertEqualsGet(response.as(Playlist.class), playlist);
        assertStatusCode(response.statusCode(), CODE_200);
    }

    @Test
    public void shouldBeAbleToUpdatePlayList() {

        Playlist playlist = playlistBuilder(generateNames(), generateDescription(), false);
        Response response = PlaylistAPI.update(playlist, DataLoader.getInstance().getUpdate_playlist_id());
        assertStatusCode(response.statusCode(), CODE_200);

    }

    @Test
    @Story("Create Playlist APIs")
    public void shouldNotBeAbleToCreatePlayListWithoutName() {
        Playlist playlist = playlistBuilder("", generateDescription(), false);
        Response response = PlaylistAPI.post(playlist);
        assertError(response.as(ErrorRoot.class), CODE_400);

    }

    @Test
    @Story("Create Playlist APIs")
    public void shouldNotBeAbleToCreatePlayListWithExpiredToken() {
        String invalidToken = "12345";
        Playlist playlist = playlistBuilder(generateNames(), generateDescription(), false);
        Response response = PlaylistAPI.post(invalidToken, playlist);
        assertError(response.as(ErrorRoot.class), CODE_401);


    }

    /****** Common methods ******/
    @Step
    public Playlist playlistBuilder(String Name, String desc, boolean _public) {

        return Playlist.builder()
                .name(Name)
                .description(desc)
                ._public(_public)
                .build();

    }

    @Step
    public Playlist getplaylistBuilder(String Name, String desc, String type) {
        return Playlist.builder()
                .name(Name)
                .description(desc)
                .type(type)
                .build();

    }

    @Step
    public void assertEquals(Playlist resPlaylist, Playlist reqPlaylist) {
        assertThat(resPlaylist.getName(), equalTo(reqPlaylist.getName()));
        assertThat(resPlaylist.getDescription(), equalTo(reqPlaylist.getDescription()));
        assertThat(resPlaylist.get_public(), equalTo(reqPlaylist.get_public()));
    }

    @Step
    public void assertError(ErrorRoot errorRootDes, StatusCode statusCode) {
        assertThat(errorRootDes.getInnerError().getStatus(), equalTo(statusCode.code));
        assertThat(errorRootDes.getInnerError().getMessage(), equalTo(statusCode.msg));
    }

    @Step
    public void assertEqualsGet(Playlist resPlaylist, Playlist reqPlaylist) {
        assertThat(resPlaylist.getName(), equalTo(reqPlaylist.getName()));
        assertThat(resPlaylist.getDescription(), equalTo(reqPlaylist.getDescription()));
        assertThat(resPlaylist.getType(), equalTo(reqPlaylist.getType()));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));

    }
}
   /*   RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setConfig(RestAssuredConfig.config().headerConfig(HeaderConfig.headerConfig().overwriteHeadersWithName("Authorization")));
        RestAssured.requestSpecification = requestSpecBuilder.build(); */
