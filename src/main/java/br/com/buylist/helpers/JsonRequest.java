package br.com.buylist.helpers;

import android.content.Context;
import android.content.res.Resources;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import br.com.buylist.R;

/**
 * Created by Igor on 11/03/2016.
 */
public class JsonRequest extends JsonObjectRequest {

    public JsonRequest(int method,
                       String route,
                       JSONObject jsonRequest,
                       Response.Listener<JSONObject> listener,
                       Response.ErrorListener errorListener, Context context) {

        super(method, context.getResources().getString(R.string.domain) + route, jsonRequest, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json; charset=utf-8");

        return headers;
    }

    @Override
    public RetryPolicy getRetryPolicy() {

        return super.getRetryPolicy();
    }
}
