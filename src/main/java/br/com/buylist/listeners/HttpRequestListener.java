package br.com.buylist.listeners;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import br.com.buylist.R;

public class HttpRequestListener implements Response.ErrorListener {

    private Context context;

    public  HttpRequestListener(Context context) {

        this.context = context;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

        String message = null;
        int code = 0;

        if (error.networkResponse != null)
            code = error.networkResponse.statusCode;

        switch (code) {

            case 400:
                message = context.getResources().getString(R.string.error400);
                break;
            case 404:
                message = context.getResources().getString(R.string.error404);
                break;
            case 500:
                message = context.getResources().getString(R.string.error500);
                break;
            default:
                message = context.getResources().getString(R.string.error0);
                break;
        }

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
