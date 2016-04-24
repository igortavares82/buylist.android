package br.com.buylist.helpers;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by Igor on 11/03/2016.
 */
public class HttpRequest {

    private static HttpRequest request = null;
    private static Context context = null;
    private RequestQueue queue = null;

    private HttpRequest (Context context) {

        this.context = context;
        this.queue = this.getQueue();

    }

    public static synchronized HttpRequest getInstance(Context context) {

        if (request == null)
            request = new HttpRequest(context);

        return  request;
    }

    public RequestQueue getQueue () {

        if (this.queue == null) {

            Cache cache = new DiskBasedCache(this.context.getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            queue = new RequestQueue(cache, network);

            queue.start();
        }
        return queue;
    }
}
