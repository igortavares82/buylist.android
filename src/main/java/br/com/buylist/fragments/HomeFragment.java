package br.com.buylist.fragments;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.buylist.R;
import br.com.buylist.adapters.HomeAdapter;

/**
 * Created by Igor on 27/04/2016.
 */
public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    private RecyclerView.LayoutManager layoutManager;

    public  HomeFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;

        try {

            view = inflater.inflate(R.layout.fragment_home, container, false);
            this.recyclerView = (RecyclerView) view.findViewById(R.id.home_lists);
            this.recyclerView.setHasFixedSize(true);
            this.layoutManager = new LinearLayoutManager(this.getActivity());
            this.recyclerView.setLayoutManager(this.layoutManager);
            this.recyclerView.setAdapter(new HomeAdapter());

        } catch (Exception e) {

        }

        return  view;
    }
}
