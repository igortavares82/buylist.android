package br.com.buylist.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;

import br.com.buylist.interfaces.IAccount;
import br.com.buylist.models.Account;

/**
 * Created by Igor on 14/03/2016.
 */
public class AccountDao implements IAccount {

    private SqLiteDao helper = null;
    private final String[] accountColumns = new String[]{ "ID", "NAME", "BIRTH", "EMAIL", "ISACTIVE", "TOKEN" };
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public AccountDao(Context context) {

        this.helper = new SqLiteDao(context);
    }

    @Override
    public boolean include(Account account) {

        Boolean response = false;

        SQLiteDatabase db =  this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(accountColumns[0], account.getId());
        values.put(accountColumns[1], account.getName());
        values.put(accountColumns[2], dateFormat.format(account.getBirth()));
        values.put(accountColumns[3], account.getEmail());
        values.put(accountColumns[4], String.valueOf(account.isActive()));
        values.put(accountColumns[5], account.getToken());

        db.insert("Account", null, values);
        db.close();
        response = true;

        return response;
    }

    @Override
    public Account getAccount() {

        Account account = new Account();

        try {

            SQLiteDatabase db =  this.helper.getWritableDatabase();
            Cursor cursor = db.query("Account", accountColumns, null, null, null, null, null);

            while(cursor.moveToNext()) {

                account.setId(cursor.getString(cursor.getColumnIndexOrThrow(accountColumns[0])));
                account.setName(cursor.getString(cursor.getColumnIndexOrThrow(accountColumns[1])));
                account.setBirth(dateFormat.parse(cursor.getString(cursor.getColumnIndexOrThrow(accountColumns[2]))));
                account.setEmail(cursor.getString(cursor.getColumnIndexOrThrow(accountColumns[3])));
                //account.setIsActive(cursor.getInt(cursor.getColumnIndexOrThrow(accountColumns[4])) == 1 ? true : false);
                account.setToken(cursor.getString(cursor.getColumnIndexOrThrow(accountColumns[5])));
            }

        } catch (Exception e) {

        }

        return account;
    }

    @Override
    public boolean remove(Account account) {

        Boolean response = false;

        SQLiteDatabase db =  this.helper.getWritableDatabase();
        db.delete("Account", String.format(" ID = '%s'", account.getId()), null);
        db.close();
        response = true;

        return  response;
    }
}
