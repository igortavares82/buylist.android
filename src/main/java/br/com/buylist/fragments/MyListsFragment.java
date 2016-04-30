package br.com.buylist.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.buylist.R;

/**
 * Created by Igor on 27/04/2016.
 */
public class MyListsFragment extends Fragment {

    public  MyListsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = null;

        try {

            view = inflater.inflate(R.layout.fragment_my_lists, container, false);

        } catch (Exception e) {

        }

        return  view;
    }
}
