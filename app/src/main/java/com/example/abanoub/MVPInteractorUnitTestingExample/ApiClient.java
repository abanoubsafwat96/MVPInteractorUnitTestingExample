package com.example.abanoub.MVPInteractorUnitTestingExample;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abanoub on 2018-03-09.
 */

public interface ApiClient {

    //@GET(".") mean that the base URL is the full path

    @GET(".") // Url remaining path
    Call<LoginResponse> getDataFromServer();

    //Use Call<List<>> when you have more than one json object on the server
//    @GET(".") // Url remaining path
//    Call<List<LoginResponse>> getDataFromServer();
}
