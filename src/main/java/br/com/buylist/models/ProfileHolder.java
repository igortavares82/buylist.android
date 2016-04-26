package br.com.buylist.models;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.buylist.R;
import br.com.buylist.listeners.LogoutListener;

/**
 * Created by Igor on 23/04/2016.
 */
public class ProfileHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public int holderId;
    public TextView textView;
    public ImageView imageView;
    public TextView name;
    public TextView email;
    public int menuId;
    private int type_view;
    private View.OnClickListener listener;

    public ProfileHolder(View itemView, int ViewType, int TYPE_ITEM) {

        super(itemView);
        this.type_view = TYPE_ITEM;

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

    private void bindListener () {

        switch (menuId) {

            case 1:
            case 2:
            case 3:
                
                break;
            case 4:

                this.listener = new LogoutListener();
                break;
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

        this.bindListener();

        if (this.listener != null)
            this.listener.onClick(v);
    }
}
