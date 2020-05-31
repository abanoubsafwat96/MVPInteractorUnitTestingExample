package com.example.abanoub.MVPInteractorUnitTestingExample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;

public class MainActivity extends AppCompatActivity implements Contract.view {

    EditText username, password;
    Button submit;
    Presenter presenter;
    MaterialDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);

        presenter = new Presenter(this,new Interactor());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.onLoginButtonPressed(username.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        if (dialog != null)
            dialog.cancel();

        dialog = getBaseProgressDialog(this).build();
        dialog.show();
    }

    @Override
    public void hideProgress() {
        if (dialog != null)
            dialog.dismiss();
        dialog=null;
    }

    @Override
    public void onSuccess() {

        Toast.makeText(this, "Succed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onfailure() {

        Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorCredential(String errorMessage) {

        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
    }

    @Override
    public void usernameCannotBeEmpty() {

        Toast.makeText(this, "Error: Username cannot be empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordCannotBeEmpty() {

        Toast.makeText(this, "Error: Password cannot be empty", Toast.LENGTH_SHORT).show();
    }


    public static MaterialDialog.Builder getBaseDialog(Context context) {
        return new MaterialDialog.Builder(context).cancelable(false).theme(Theme.LIGHT).widgetColorRes(R.color.colorAccent).titleColorRes(R.color.colorAccent)
                .contentColorRes(R.color.colorAccent).positiveColorRes(R.color.colorAccent).negativeColorRes(R.color.colorAccent);
    }

    public static MaterialDialog.Builder getBaseProgressDialog(Context context) {
        return getBaseDialog(context).progress(true, 0).progressIndeterminateStyle(true).cancelable(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (dialog!=null)
            dialog = null;
    }
}
