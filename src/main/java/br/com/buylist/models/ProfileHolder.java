package br.com.buylist.models;

import android.accounts.*;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;

/**
 * Created by Igor on 23/04/2016.
 */
public class ProfileHolder extends RecyclerView.ViewHolder {

    public int Holderid;

    public TextView textView;
    public ImageView imageView;
    public ImageView profile;
    public TextView Name;
    public TextView Email;


    public ProfileHolder(View itemView,int ViewType, int TYPE_ITEM) { // Creating ViewHolder Constructor with View and viewType As a parameter

        super(itemView);

        // Here we set the appropriate view in accordance with the the view type as passed when the holder object is created

        if(ViewType == TYPE_ITEM) {

            textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from item_row.xml
            imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from item_row.xml
            Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row

        } else {

            Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from header.xml for name
            Email = (TextView) itemView.findViewById(R.id.email);       // Creating Text View object from header.xml for email
            //profile = (ImageView) itemView.findViewById(R.id.circleView);// Creating Image view object from header.xml for profile pic
            Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type header view
        }
    }
}
