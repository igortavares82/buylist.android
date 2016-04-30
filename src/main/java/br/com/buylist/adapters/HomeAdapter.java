package br.com.buylist.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    private java.util.List<List> lists = Collections.EMPTY_LIST;
    private int totalItemCount;
    private int lastVisibleItem;
    private int visibleThreshold;
    private boolean loading;
    private IOnLoadMoreListener onLoadMoreListener;

    //https://codentrick.com/load-more-recyclerview-bottom-progressbar/

    public HomeAdapter(java.util.List<T> lists, RecyclerView recyclerView) {

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int x, int y) {

                super.onScrolled(recyclerView, x, y);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!loading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }

                    loading = true;
                }
            }
        });
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.holder_home, parent, false);

        return new HomeHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {

        holder.id.setText(this.lists.get(position).getId());
        holder.name.setText(this.lists.get(position).getName());
        holder.description.setText(this.lists.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return this.lists.size();
    }

    private void setOnLoadMoreListener(IOnLoadMoreListener onLoadMoreListener) {

        this.onLoadMoreListener = onLoadMoreListener;
    }
}
