package br.com.buylist.listeners;

import android.content.Intent;
import android.view.View;

import br.com.buylist.dao.AccountDao;
import br.com.buylist.views.Login;

/**
 * Created by Igor on 24/04/2016.
 */
public class LogoutListener implements View.OnClickListener {

    @Override
    public void onClick(View view)
    {
        AccountDao accountDao = new AccountDao(view.getContext());
        accountDao.remove(accountDao.getAccount());

        Intent intent = new Intent(view.getContext(), Login.class);
        view.getContext().startActivity(intent);
    }
}
