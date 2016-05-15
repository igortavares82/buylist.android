package br.com.buylist.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;

import br.com.buylist.holders.HomeHolder;
import br.com.buylist.interfaces.IOnLoadMoreListener;
import br.com.buylist.models.List;

import br.com.buylist.R;

/**
 * Created by Igor on 29/04/2016.
 */
public class HomeAdapter<T> extends RecyclerView.Adapter<HomeHolder> {

    private java.util.List<T> lists = Collections.EMPTY_LIST;
    private int totalItemCount;
    private int lastVisibleItem;
    private int visibleThreshold;
    private boolean loading;
    private IOnLoadMoreListener onLoadMoreListener;

    //https://codentrick.com/load-more-recyclerview-bottom-progressbar/

    public HomeAdapter(java.util.List<T> lists, RecyclerView recyclerView) {

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.lists = lists;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.holder_home, parent, false);

        return new HomeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {

        br.com.buylist.models.List list = (br.com.buylist.models.List) this.lists.get(position);

        holder.id.setText(list.getId());
        holder.name.setText(list.getName());
        holder.description.setText(list.getDescription());

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        holder.createDate.setText(String.format("Create date: %s", sdf.format(list.getCreateDate())));
    }

    @Override
    public int getItemCount() {
        return this.lists.size();
    }

    private void setOnLoadMoreListener(IOnLoadMoreListener onLoadMoreListener) {

        this.onLoadMoreListener = onLoadMoreListener;
    }
}
