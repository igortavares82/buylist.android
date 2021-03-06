package br.com.buylist.helpers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;
import br.com.buylist.interfaces.IAccount;
import br.com.buylist.models.Account;

/**
 * Created by Igor on 14/03/2016.
 */
public class UtilHelper {

    public static boolean checkConnection(Context context) {

        boolean response = true;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if (ni == null || !ni.isAvailable() || !ni.isConnected()) {

            response = false;
            Toast.makeText(context, context.getResources().getString(R.string.connection_unavailable), Toast.LENGTH_LONG).show();
        }

        return  response;
    }

    public static String getUserToken(Context context) {

        IAccount accountDao = new AccountDao(context);
        Account account = accountDao.getAccount();

        return account.getToken();
    }
}
