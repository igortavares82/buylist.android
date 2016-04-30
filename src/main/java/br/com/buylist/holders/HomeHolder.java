package br.com.buylist.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.buylist.R;

/**
 * Created by Igor on 29/04/2016.
 */
public class HomeHolder extends RecyclerView.ViewHolder {

    public TextView id;
    public TextView name;
    public TextView description;
    public TextView createDate;

    public HomeHolder(View itemView) {

        super(itemView);

        this.id = (TextView) itemView.findViewById(R.id.txtId);
        this.name = (TextView) itemView.findViewById(R.id.txtName);
        this.description = (TextView) itemView.findViewById(R.id.txtDescription);
        this.createDate = (TextView) itemView.findViewById(R.id.txtCreateDate);
    }
}