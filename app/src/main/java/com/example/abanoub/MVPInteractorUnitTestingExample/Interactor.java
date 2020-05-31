package com.example.abanoub.MVPInteractorUnitTestingExample;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abanoub on 2018-03-22.
 */

public class Interactor implements Contract.loginInteractor {

    Contract.interactorOutput presenter;
    Retrofit.Builder builder;

    @Override
    public void setPresenter(Contract.interactorOutput presenter) {
        this.presenter = presenter;
    }

    @Override
    public void login(String username, String password) {

        presenter.showProgressHelper();

        builder = new Retrofit.Builder()
                .baseUrl("http://polls.apiblueprint.org/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        // Create a very simple REST adapter which points the GitHub API endpoint.
        ApiClient client = retrofit.create(ApiClient.class);

        // Execute the call asynchronously. Get a positive or negative callback.
        client.getDataFromServer().enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.e("onResponse: ", "success");

                LoginResponse loginResponse = response.body();

                Log.e("url: ", loginResponse.getUrl());
                Log.e("question_url: ", loginResponse.getQuestions_url());

                presenter.hideProgressHelper();

                presenter.onLoginSuccess(loginResponse);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("onResponse: ", "failed");

                presenter.hideProgressHelper();

                presenter.onLoginError(t.getMessage().toString());
            }
        });
    }
}
