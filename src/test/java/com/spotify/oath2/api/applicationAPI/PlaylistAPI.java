package com.spotify.oath2.api.applicationAPI;

import com.spotify.oath2.api.RestResources;
import com.spotify.oath2.pojo.Playlist;
import com.spotify.oath2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oath2.api.Route.PLAYLISTS;
import static com.spotify.oath2.api.Route.*;
import static com.spotify.oath2.api.TokenManager.getToken;

public class PlaylistAPI {
    //  static String accessToken = "BQACEqW_eGoHFZ9miYy4M418hdZIFW3W0m7PzV5US27fCKVFNyiWyopYGV9E7kJeqDsXimZ-NHNCphe0TWOV5PL2b9r9fXQDXpGUgncDpfqNruVTLuO0xEWME9n-wYeNAv6BEpcip4YEI4upxANzwi9KMBok5E_FdyH6eN3ol47DDIpfnAQ9ZIkh1chzmEle726PzkkhCiEz_zgzid9yuG4DetXv1h_Mb4tR_isy3Ul5JCjymGKXeALnVfAsReDql9w";
    @Step
    public static Response post(Playlist playlist) {
        return RestResources.post(USERS + "/" + ConfigLoader.getInstance().getUser_id() + "/" + PLAYLISTS, getToken(), playlist);
    }

    public static Response post(String invalidToken, Playlist playlist) {
        return RestResources.post(USERS + "/" + ConfigLoader.getInstance().getUser_id() + "/" + PLAYLISTS, invalidToken, playlist);

    }

    public static Response get(String playlistID) {
        return RestResources.get(PLAYLISTS + "/" + playlistID, getToken());

    }

    public static Response update(Playlist playlist, String playlistID) {
        return RestResources.update(PLAYLISTS + "/" + playlistID, getToken(), playlist);
    }
}
