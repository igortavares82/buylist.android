package br.com.buylist.models;

import android.accounts.*;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import br.com.buylist.R;
import br.com.buylist.dao.AccountDao;
import br.com.buylist.listeners.LogoutListener;
import br.com.buylist.views.Login;

/**
 * Created by Igor on 23/04/2016.
 */
public class ProfileHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public int Holderid;
    public TextView textView;
    public ImageView imageView;
    public ImageView profile;
    public TextView Name;
    public TextView Email;
    public int menuId;

    private int type_view;
    private View.OnClickListener listener;

    public ProfileHolder(View itemView, int ViewType, int TYPE_ITEM) { // Creating ViewHolder Constructor with View and viewType As a parameter

        super(itemView);
        this.type_view = TYPE_ITEM;

        if(ViewType == TYPE_ITEM) {



            textView = (TextView) itemView.findViewById(R.id.rowText); // Creating TextView object with the id of textView from nv_drawer_row.xmlw.xml
            imageView = (ImageView) itemView.findViewById(R.id.rowIcon);// Creating ImageView object with the id of ImageView from nv_drawer_row.xmlw.xml
            textView.setOnClickListener(this);
            Holderid = 1;                                               // setting holder id as 1 as the object being populated are of type item row

        } else {

            Name = (TextView) itemView.findViewById(R.id.name);         // Creating Text View object from nv_drawer_headerwer_header.xml for name
            Email = (TextView) itemView.findViewById(R.id.email);       // Creating Text View object from nv_drawer_headerwer_header.xml for email
            //profile = (ImageView) itemView.findViewById(R.id.circleView);// Creating Image view object from nv_drawer_headerwer_header.xml for profile pic
            Holderid = 0;                                                // Setting holder id = 0 as the object being populated are of type nv_drawer_header view
        }
    }

    private void bindListener () {

        switch (menuId) {

            case 1:
            case 2:
                break;
            case 3:

                this.listener = new LogoutListener();
                break;
        }
    }

    @Override
    public void onClick(View v) {

        v.getParent().getParent();

        LinearLayout linearLayout = (LinearLayout) v.getParent();
        linearLayout.setBackgroundColor(Color.BLUE);

        this.bindListener();

        if (this.listener != null)
            this.listener.onClick(v);
    }
}
