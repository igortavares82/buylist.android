package br.com.buylist.listeners;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import br.com.buylist.R;
import br.com.buylist.adapters.HomeAdapter;

/**
 * Created by Igor on 08/05/2016.
 */
public class ListsListener implements Response.Listener {

    private Activity activity;
    private Context context;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    public ListsListener(Context context, RecyclerView recyclerView, Activity activity) {

        this.activity = activity;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    @Override
    public void onResponse(Object response) {

        try {

            List<br.com.buylist.models.List> lists = new ArrayList<br.com.buylist.models.List>();

            JSONArray listsJson = new JSONArray(response.toString());

            for(int i = 0, ii = listsJson.length(); i < ii; i++) {

                JSONObject listJson = listsJson.getJSONObject(i);
                br.com.buylist.models.List list = new br.com.buylist.models.List();

                list.setId(listJson.getString("_id"));
                list.setName(listJson.getString("name"));
                list.setIsPublic(listJson.getBoolean("isPublic"));
                list.setIsDraft(listJson.getBoolean("isDraft"));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                list.setCreateDate(sdf.parse(listJson.getString("createDate").substring(0, 10)));

                if (listJson.has("description"))
                    list.setDescription(listJson.getString("description"));
                else
                    list.setDescription("-");

                lists.add(list);
            }

            this.recyclerView.setHasFixedSize(true);
            this.recyclerView.setAdapter(new HomeAdapter<br.com.buylist.models.List>(lists, this.recyclerView));
            this.layoutManager = new LinearLayoutManager(this.activity);
            this.recyclerView.setLayoutManager(this.layoutManager);

        }catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}
