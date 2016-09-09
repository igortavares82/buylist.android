package br.com.buylist.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import br.com.buylist.R;

/**
 * Created by Igor on 08/09/2016.
 */
public class LoadingHolder extends RecyclerView.ViewHolder {

    public ProgressBar progressBar;

    public LoadingHolder(View view) {

        super(view);
        this.progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
    }
}
