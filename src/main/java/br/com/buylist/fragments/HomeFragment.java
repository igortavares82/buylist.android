package br.com.buylist.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.buylist.R;
import br.com.buylist.helpers.HttpRequest;
import br.com.buylist.helpers.StrRequest;
import br.com.buylist.helpers.UtilHelper;
import br.com.buylist.interfaces.IAccount;
import br.com.buylist.listeners.HttpRequestListener;
import br.com.buylist.listeners.ListsListener;
import br.com.buylist.models.Account;

/**
 * Created by Igor on 27/04/2016.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    public  HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;

        try {

            view = inflater.inflate(R.layout.fragment_home, container, false);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.home_lists);
            this.getLists();

        } catch (Exception e) {
            //TODO: Log de erro
        }

        return  view;
    }

    private void getLists() {

        HttpRequestListener httpReqListener = new HttpRequestListener(this.getContext());
        ListsListener listsListener = new ListsListener(this.getContext(), this.recyclerView, super.getActivity());

        Map<String,String> params = new HashMap<String, String>();
        params.put("isPublic", "true");
        params.put("x-access-token", UtilHelper.getUserToken(this.getContext()));

        HttpRequest request = HttpRequest.getInstance(this.getContext());
        StrRequest strRequest = new StrRequest(Request.Method.GET, "list/all/", params, listsListener, httpReqListener, this.getContext());

        strRequest.setTag("list.all.request");
        request.getQueue().add(strRequest);
    }
}
