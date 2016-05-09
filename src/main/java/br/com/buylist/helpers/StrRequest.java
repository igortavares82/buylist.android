package br.com.buylist.helpers;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;
import br.com.buylist.interfaces.IAccount;
import br.com.buylist.models.Account;

/**
 * Created by Igor on 11/03/2016.
 */
public class StrRequest extends StringRequest {

    private Map<String,String> params = null;
    private Context context;

    public StrRequest(int method,
                      String route,
                      Map<String,String> params,
                      Response.Listener<String> listener,
                      Response.ErrorListener errorListener,
                      Context context) {

        super(method, context.getResources().getString(R.string.domain) + route, listener, errorListener);
        this.context = context;
        this.params = params;
    }

    @Override
    protected Map<String,String> getParams() {

        return this.params;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        Map<String,String> params = new HashMap<String, String>();
        params.put("Content-Type","application/x-www-form-urlencoded");

        return params;
    }

    @Override
    public RetryPolicy getRetryPolicy() {

        return super.getRetryPolicy();
    }
}
