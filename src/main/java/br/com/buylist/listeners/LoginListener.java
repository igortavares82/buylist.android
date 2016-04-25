package br.com.buylist.listeners;

import android.content.Context;
import android.content.Intent;

import com.android.volley.Response;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;
import br.com.buylist.interfaces.IAccount;
import br.com.buylist.models.*;
import br.com.buylist.views.Home;

/**
 * Created by Igor on 11/03/2016.
 */
public class LoginListener implements Response.Listener {

    private Context context;
    private final SimpleDateFormat dateFormat;
    private IAccount accountDado;

    public LoginListener(Context context) {

        this.context = context;
        this.accountDado = new AccountDao(this.context);
        this.dateFormat = new SimpleDateFormat(this.context.getResources().getString(R.string.date_format));
    }

    @Override
    public void onResponse(Object response) {

        try {

            JSONObject json = new JSONObject(response.toString());
            JSONObject accountJson = json.getJSONArray("account").getJSONObject(0);

            Account account = new Account();
            account.setId(accountJson.get("_id").toString());
            account.setName(accountJson.get("name").toString());

            Date birth = dateFormat.parse(accountJson.get("birth").toString().substring(0, 10));

            account.setBirth(birth);
            account.setEmail(accountJson.get("email").toString());
            account.setIsActive(Boolean.valueOf(accountJson.get("isActive").toString()));
            account.setToken(json.get("token").toString());

            this.accountDado.remove(account);
            this.accountDado.include(account);

            Intent intent = new Intent(this.context, Home.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.context.startActivity(intent);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
