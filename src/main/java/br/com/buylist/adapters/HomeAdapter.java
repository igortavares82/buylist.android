package br.com.buylist.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;

import br.com.buylist.fragments.HomeFragment;
import br.com.buylist.holders.HomeHolder;
import br.com.buylist.holders.LoadingHolder;
import br.com.buylist.interfaces.IOnLoadMoreListener;
import br.com.buylist.models.List;

import br.com.buylist.R;

/**
 * Created by Igor on 29/04/2016.
 */
public class HomeAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private java.util.List<T> lists = Collections.EMPTY_LIST;
    private int totalItemCount;
    private int lastVisibleItem;
    private int visibleThreshold;
    private boolean isLoading;
    private IOnLoadMoreListener onLoadMoreListener;

    //https://codentrick.com/load-more-recyclerview-bottom-progressbar/

    public HomeAdapter(java.util.List<T> lists, RecyclerView recyclerView) {

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.lists = lists;

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int x, int y) {

                super.onScrolled(recyclerView, x, y);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();

                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {

                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());


        if (viewType == VIEW_TYPE_ITEM) {

            View view = layoutInflater.inflate(R.layout.holder_home, parent, false);
            return new HomeHolder(view);
        } else {

            View view = layoutInflater.inflate(R.layout.hold_loading, parent, false);
            return new LoadingHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HomeHolder) {

            br.com.buylist.models.List list = (br.com.buylist.models.List) this.lists.get(position);
            HomeHolder home = (HomeHolder)holder;

            home.id.setText(list.getId());
            home.name.setText(list.getName());
            home.description.setText(list.getDescription());

            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            home.createDate.setText(String.format("Create date: %s", sdf.format(list.getCreateDate())));

        } else if (holder instanceof LoadingHolder) {

            LoadingHolder loadingHolder = (LoadingHolder) holder;
            loadingHolder.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return this.lists.get(position) == null ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        return this.lists.size();
    }

    private void setOnLoadMoreListener(IOnLoadMoreListener onLoadMoreListener) {

        this.onLoadMoreListener = onLoadMoreListener;
    }
}
