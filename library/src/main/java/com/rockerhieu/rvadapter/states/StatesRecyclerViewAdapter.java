package com.rockerhieu.rvadapter.states;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.rockerhieu.rvadapter.RecyclerViewAdapterWrapper;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author rockerhieu on 8/11/15.
 */
public class StatesRecyclerViewAdapter extends RecyclerViewAdapterWrapper {
    private final View vLoadingView;
    private final View vEmptyView;
    private final View vErrorView;

    @IntDef({STATE_NORMAL, STATE_LOADING, STATE_EMPTY, STATE_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
    }

    public static final int STATE_NORMAL = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_EMPTY = 2;
    public static final int STATE_ERROR = 3;

    public static final int TYPE_LOADING = 1000;
    public static final int TYPE_EMPTY = 1001;
    public static final int TYPE_ERROR = 1002;
    @State
    private int state = STATE_NORMAL;

    public StatesRecyclerViewAdapter(@NonNull RecyclerView.Adapter wrapped, @Nullable View loadingView, @Nullable View emptyView, @Nullable View errorView) {
        super(wrapped);
        this.vLoadingView = loadingView;
        this.vEmptyView = emptyView;
        this.vErrorView = errorView;
    }

    @State
    public int getState() {
        return state;
    }

    public void setState(@State int state) {
        this.state = state;
        getWrappedAdapter().notifyDataSetChanged();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        switch (state) {
            case STATE_LOADING:
            case STATE_EMPTY:
            case STATE_ERROR:
                return 1;
        }
        return super.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        switch (state) {
            case STATE_LOADING:
                return TYPE_LOADING;
            case STATE_EMPTY:
                return TYPE_EMPTY;
            case STATE_ERROR:
                return TYPE_ERROR;
        }
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_LOADING:
                return new SimpleViewHolder(vLoadingView);
            case TYPE_EMPTY:
                return new SimpleViewHolder(vEmptyView);
            case TYPE_ERROR:
                return new SimpleViewHolder(vErrorView);
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (state) {
            case STATE_LOADING:
                onBindLoadingViewHolder(holder, position);
                break;
            case STATE_EMPTY:
                onBindEmptyViewHolder(holder, position);
                break;
            case STATE_ERROR:
                onBindErrorViewHolder(holder, position);
                break;
            default:
                super.onBindViewHolder(holder, position);
                break;
        }
    }

    public void onBindErrorViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    public void onBindEmptyViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    public void onBindLoadingViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public SimpleViewHolder(View itemView) {
            super(itemView);
        }
    }
}
