package com.example.abanoub.MVPInteractorUnitTestingExample;

/**
 * Created by Abanoub on 2018-03-04.
 */

public class LoginResponse {
//    server attributes must be the same variable names to be recoginzed
//    or use @SerializedName("url") with different variable name
    String url;
    String questions_url;

    public String getUrl() {
        return url;
    }

    public String getQuestions_url() {
        return questions_url;
    }

}
