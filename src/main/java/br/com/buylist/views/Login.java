package br.com.buylist.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;
import br.com.buylist.interfaces.IAccount;
import br.com.buylist.models.*;
import br.com.buylist.helpers.HttpRequest;
import br.com.buylist.helpers.StrRequest;
import br.com.buylist.helpers.UtilHelper;
import br.com.buylist.listeners.HttpRequestListener;
import br.com.buylist.listeners.LoginListener;

/**
 * Created by Igor on 17/02/2016.
 */
public class Login extends Activity {

    final private Login login = this;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        IAccount accountDao = new AccountDao(this.getApplicationContext());
        Account account = accountDao.getAccount();

        if (account != null) {

            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) { login.onLogin(); }
        });
    }

    public final void onLogin () {

        final EditText user = (EditText) findViewById(R.id.txtUser);
        final EditText pass = (EditText) findViewById(R.id.txtPassword);

        if (!UtilHelper.checkConnection(this.getApplicationContext()))
            return;

        HttpRequestListener httpReqListener = new HttpRequestListener(this.getApplicationContext());
        LoginListener loginListener = new LoginListener(this.getApplicationContext());

        Map<String,String> params = new HashMap<String, String>();
        params.put("username", user.getText().toString());
        params.put("password", pass.getText().toString());

        HttpRequest request = HttpRequest.getInstance(this.getApplicationContext());
        StrRequest strRequest = new StrRequest(Request.Method.POST, "account/auth/", params, loginListener, httpReqListener, this.getApplicationContext());

        strRequest.setTag("login.request");
        request.getQueue().add(strRequest);
    }
}
