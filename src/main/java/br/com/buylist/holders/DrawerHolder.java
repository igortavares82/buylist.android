package br.com.buylist.holders;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.buylist.R;
import br.com.buylist.fragments.HomeFragment;
import br.com.buylist.fragments.MyListsFragment;
import br.com.buylist.listeners.LogoutListener;

/**
 * Created by Igor on 23/04/2016.
 */
public class DrawerHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public int holderId;
    public TextView textView;
    public ImageView imageView;
    public TextView name;
    public TextView email;
    public int menuId;

    private int type_view;
    private FragmentManager fragmentManager;
    private DrawerLayout drawerLayout;

    public DrawerHolder(View itemView, int ViewType, int TYPE_ITEM, FragmentManager fragmentManager, DrawerLayout drawerLayout) {

        super(itemView);
        this.type_view = TYPE_ITEM;
        this.fragmentManager = fragmentManager;
        this.drawerLayout = drawerLayout;

        if(ViewType == TYPE_ITEM) {

            textView = (TextView) itemView.findViewById(R.id.rowText);
            imageView = (ImageView) itemView.findViewById(R.id.rowIcon);

            LinearLayout linearLayout = (LinearLayout) textView.getParent();
            linearLayout.setOnClickListener(this);

            holderId = 1;

        } else {

            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);

            holderId = 0;
        }
    }

    @Override
    public void onClick(View v) {

        RecyclerView recyclerView = (RecyclerView) v.getParent();

        for (int i = 0; i < recyclerView.getChildCount(); i++) {

            if (recyclerView.getChildAt(i) instanceof LinearLayout) {

                LinearLayout linearLayout = (LinearLayout) recyclerView.getChildAt(i);
                linearLayout.setBackgroundColor(Color.TRANSPARENT);
            }
        }

        v.setBackgroundColor(v.getContext().getResources().getColor(R.color.ColorPrimaryDark));

        switch (menuId) {

            case 1:

                this.fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, new HomeFragment())
                    .commit();

                break;

            case 2:

                this.fragmentManager
                    .beginTransaction()
                    .replace(R.id.content_frame, new MyListsFragment())
                    .commit();

                break;

            case 3:

                break;

            case 4:

                View.OnClickListener listener = new LogoutListener();
                listener.onClick(v);

                break;
        }

        this.drawerLayout.closeDrawer(Gravity.LEFT);
    }
}
