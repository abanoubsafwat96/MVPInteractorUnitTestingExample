package com.example.abanoub.MVPInteractorUnitTestingExample;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception {
//        assertEquals(4, 2 + 2);
//    }

    @Mock
    public Contract.view view;
    @Mock
    public Contract.loginInteractor myInteractor;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void login_correctCredential_shouldSucced() throws Exception {

        // Arrange
        Contract.presenter presenter = new Presenter(view,myInteractor);

        // Act
        presenter.onLoginButtonPressed("Abanoub", "123456");

        // Assert
        verify(myInteractor, Mockito.times(1)).login("Abanoub", "123456");
        verify(view, Mockito.times(1)).showProgress();
        verify(view, Mockito.times(1)).hideProgress();
        verify(view, Mockito.times(1)).onSuccess();

        verify(view, Mockito.never()).onfailure();
        verify(view, Mockito.never()).showErrorCredential("");
        verify(view, Mockito.never()).usernameCannotBeEmpty();
        verify(view, Mockito.never()).passwordCannotBeEmpty();
    }

    @Test
    public void login_usernameIsEmpty_shouldSucced() throws Exception {

        // Arrange
        Contract.presenter presenter = new Presenter(view,myInteractor);

        // Act
        presenter.onLoginButtonPressed("", "123456");

        // Assert
        verify(view, Mockito.times(1)).usernameCannotBeEmpty();

        verify(view, Mockito.never()).showProgress();
        verify(view, Mockito.never()).hideProgress();
        verify(view, Mockito.never()).onSuccess();
        verify(view, Mockito.never()).onfailure();
        verify(view, Mockito.never()).showErrorCredential("error");
        verify(view, Mockito.never()).passwordCannotBeEmpty();
        verify(myInteractor,Mockito.never()).login("","123456");
    }

    @Test
    public void login_passwordIsEmpty_shouldSucced() throws Exception {

        // Arrange
        Contract.presenter presenter = new Presenter(view,myInteractor);

        // Act
        presenter.onLoginButtonPressed("Abanoub", "");

        // Assert
        verify(view, Mockito.times(1)).passwordCannotBeEmpty();

        verify(view, Mockito.never()).showProgress();
        verify(view, Mockito.never()).hideProgress();
        verify(view, Mockito.never()).onSuccess();
        verify(view, Mockito.never()).onfailure();
        verify(view, Mockito.never()).showErrorCredential("error");
        verify(view, Mockito.never()).usernameCannotBeEmpty();
        verify(myInteractor,Mockito.never()).login("Abanoub","");
    }

    @Test
    public void login_usernameAndPasswordIsEmpty_shouldSucced() throws Exception {

        // Arrange
        Contract.presenter presenter = new Presenter(view,myInteractor);

        // Act
        presenter.onLoginButtonPressed("", "");

        // Assert
        verify(view, Mockito.times(1)).usernameCannotBeEmpty();
        verify(view, Mockito.times(1)).passwordCannotBeEmpty();

        verify(view, Mockito.never()).showProgress();
        verify(view, Mockito.never()).hideProgress();
        verify(view, Mockito.never()).onSuccess();
        verify(view, Mockito.never()).onfailure();
        verify(view, Mockito.never()).showErrorCredential("error");
        verify(myInteractor,Mockito.never()).login("","");
    }

    @Test
    public void onDestroy_viewIsEmpty_shouldSucced() throws Exception {

        // Arrange
        Contract.presenter presenter = new Presenter(view,myInteractor);

        // Act
        presenter.onDestroy();
//        view=null;
//        myInteractor=null;

        // Assert
        assertNull(view);
        assertNull(myInteractor);
    }

    //lazm kolo y fail fl awl 3shan lsa m3mltsh al implementation
    //b3d ma a3ml al implementation lazm kolo y-success f yb2a m3nah an al code bta3k wl test saleem
}

