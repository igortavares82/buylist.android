package br.com.buylist.views;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import br.com.buylist.dao.AccountDao;
import br.com.buylist.models.Account;
import br.com.buylist.models.ProfileHolder;

import br.com.buylist.R;

/**
 * Created by Igor on 23/04/2016.
 */
public class NvDrawerHeader extends RecyclerView.Adapter {

    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    private static final int TYPE_ITEM = 1;

    private String titles[]; // String Array to store the passed titles Value from MainActivity.java
    private int icons[];       // Int Array to store the passed icons resource value from MainActivity.java
    private Context context;

    NvDrawerHeader(String titles[], int Icons[], Context context) {

        this.titles = titles;
        this.icons = Icons;
        this.context = context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nv_drawer_row,parent,false); //Inflating the layout
            ProfileHolder vhItem = new ProfileHolder(v, viewType, TYPE_ITEM);//new ViewHolder(v,viewType); //Creating ViewHolder and passing the object of type view

            return vhItem; // Returning the created object

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nv_drawer_header,parent,false); //Inflating the layout
            ProfileHolder vhHeader = new ProfileHolder(v, viewType, TYPE_ITEM); //Creating ViewHolder and passing the object of type view

            return vhHeader; //returning the object created
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ProfileHolder pHolder = (ProfileHolder) holder;

        if(pHolder.holderId == 1) {

            pHolder.textView.setText(titles[position - 1]);
            pHolder.imageView.setImageResource(icons[position - 1]);
            pHolder.menuId = position;

            if (position == 1)
                holder.itemView.setBackgroundColor(holder.itemView.getContext().getResources().getColor(R.color.ColorPrimaryDark));

        } else {

            AccountDao accountDao = new AccountDao(this.context);
            Account account = accountDao.getAccount();

            pHolder.name.setText(account.getName());
            pHolder.email.setText(account.getEmail());
        }
    }

    @Override
    public int getItemCount() {
        return titles.length + 1;
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
