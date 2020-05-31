package com.example.abanoub.MVPInteractorUnitTestingExample;

/**
 * Created by Abanoub on 2018-03-04.
 */

public class Presenter implements Contract.presenter, Contract.interactorOutput {

    public Contract.view view;
    public Contract.loginInteractor interactor;

    public Presenter(Contract.view view, Contract.loginInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
        interactor.setPresenter(this);
    }

    @Override
    public void onLoginButtonPressed(String username, String password) {

        if (username.isEmpty())
            view.usernameCannotBeEmpty();
        if (password.isEmpty())
            view.passwordCannotBeEmpty();
        if (!username.isEmpty() && !password.isEmpty())
            interactor.login(username, password);
    }

    @Override
    public void onDestroy() {

        view = null;
        interactor = null;
    }

    @Override
    public void showProgressHelper() {
        view.showProgress();
    }

    @Override
    public void hideProgressHelper() {
        view.hideProgress();
    }

    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        view.onSuccess();
    }

    @Override
    public void onLoginError(String errorMessage) {
        view.onfailure();
        view.showErrorCredential(errorMessage);
    }
}
