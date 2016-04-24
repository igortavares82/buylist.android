package br.com.buylist.interfaces;

import br.com.buylist.dao.AccountDao;
import br.com.buylist.models.*;

/**
 * Created by Igor on 14/03/2016.
 */
public interface IAccount {

    boolean include(Account account);
    Account getAccount();
    boolean remove (Account account);
}
