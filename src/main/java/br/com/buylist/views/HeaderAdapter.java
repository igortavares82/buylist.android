package br.com.buylist.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.buylist.dao.AccountDao;
import br.com.buylist.models.Account;
import br.com.buylist.models.ProfileHolder;

import br.com.buylist.R;

/**
 * Created by Igor on 23/04/2016.
 */
public class HeaderAdapter extends RecyclerView.Adapter {

    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    private static final int TYPE_ITEM = 1;

    private String navTitles[]; // String Array to store the passed titles Value from MainActivity.java
    private int mIcons[];       // Int Array to store the passed icons resource value from MainActivity.java

    private String name;        //String Resource for header View Name
    private int profile;        //int Resource for header view profile picture
    private String email;
    private Context context;


    HeaderAdapter(String Titles[],int Icons[], Context context) {

        navTitles = Titles;
        mIcons = Icons;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false); //Inflating the layout
            ProfileHolder vhItem = new ProfileHolder(v, viewType, TYPE_ITEM);//new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.header,parent,false); //Inflating the layout
            ProfileHolder vhHeader = new ProfileHolder(v, viewType, TYPE_ITEM); //Creating ViewHolder and passing the object of type view

            return vhHeader; //returning the object created
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProfileHolder pHolder = (ProfileHolder) holder;

        if(pHolder.Holderid == 1) { // as the list view is going to be called after the header view so we decrement the

            // position by 1 and pass it to the holder while setting the text and image
            pHolder.textView.setText(navTitles[position - 1]); // Setting the Text with the array of our Titles
            pHolder.imageView.setImageResource(mIcons[position -1]);// Settimg the image with array of our icons

        } else {

            AccountDao accountDao = new AccountDao(this.context);
            Account account = accountDao.getAccount();

            //pHolder.profile.setImageResource(profile);           // Similarly we set the resources for header view
            pHolder.Name.setText(account.getName());
            pHolder.Email.setText(account.getEmail());
        }
    }

    @Override
    public int getItemCount() {
        return navTitles.length + 1;
    }

    @Override
    public int getItemViewType(int position) {

        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }
}
