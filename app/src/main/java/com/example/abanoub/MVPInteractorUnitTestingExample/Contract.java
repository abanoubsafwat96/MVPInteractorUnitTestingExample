package com.example.abanoub.MVPInteractorUnitTestingExample;

/**
 * Created by Abanoub on 2018-03-04.
 */

public interface Contract {

    interface view {

        void showProgress();
        void hideProgress();
        void onSuccess();
        void onfailure();
        void showErrorCredential(String errorMessage);
        void usernameCannotBeEmpty();
        void passwordCannotBeEmpty();

    }

    interface presenter {

        void onLoginButtonPressed(String username, String password);
        void onDestroy();
    }

    interface loginInteractor{

        void setPresenter(Contract.interactorOutput presenter);
        void login(String username, String password);

    }

    interface interactorOutput {

        void showProgressHelper();
        void hideProgressHelper();
        void onLoginSuccess(LoginResponse loginResponse);
        void onLoginError(String errorMessage);
    }
}
