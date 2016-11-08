package com.example.espino.manageproductrecycler.presenters;

import android.content.Context;
import android.text.TextUtils;

import com.example.espino.manageproductrecycler.Modelo.User;
import com.example.espino.manageproductrecycler.ProductApplication;
import com.example.espino.manageproductrecycler.R;
import com.example.espino.manageproductrecycler.interfaces.IloginMVP;

/**
 * Created by usuario on 6/10/16.
 */

public class LoginPresenter implements IloginMVP.Presenter {



    private IloginMVP.View view;

    public LoginPresenter(IloginMVP.View view){

        this.view = view;
    }
    public void validateCredentials(String pass, String user) {

        if(TextUtils.isEmpty(user)){
            view.setMessage(((Context)view).getResources().getString(R.string.data_empty), R.id.editUser);

        }else if(TextUtils.isEmpty(pass)){

            view.setMessage(((Context)view).getResources().getString(R.string.data_empty), R.id.editPasswd);
        }
        else if (!pass.matches("(.*)\\d+(.*)")) {
            view.setMessage(((Context)view).getResources().getString(R.string.passwd_digit), R.id.editPasswd);
        }
        // least upperCase and one lowerCase
        else if (!pass.matches("(.*)\\p{Lower}+(.*)")) {
            view.setMessage(((Context)view).getResources().getString(R.string.passwd_case), R.id.editPasswd);
        }
        else if (!pass.matches("(.*)\\p{Upper}+(.*)")) {
            view.setMessage(((Context)view).getResources().getString(R.string.passwd_case), R.id.editPasswd);
        }
        else if (pass.length() <=7) {
            view.setMessage(((Context)view).getResources().getString(R.string.passwd_length), R.id.editPasswd);
        }else {
            view.setMessage(((Context)view).getResources().getString(R.string.ok), 0);

            ((ProductApplication)((Context)view).getApplicationContext()).setUser(new User(user, pass));
        }

    }
}
