/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.rockerhieu.rvadapter.states.example;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.rockerhieu.rvadapter.states.StatesRecyclerViewAdapter;
import com.rockerhieu.rvadapter.states.example.adapter.SimpleStringAdapter;
import com.rockerhieu.rvadapter.states.example.decorator.DividerItemDecoration;

public class MainActivity extends Activity {
    private StatesRecyclerViewAdapter statesRecyclerViewAdapter;
    private SimpleStringAdapter adapter;
    private View loadingView;
    private View emptyView;
    private View errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        loadingView = getLayoutInflater().inflate(R.layout.view_loading, rv, false);
        emptyView = getLayoutInflater().inflate(R.layout.view_empty, rv, false);
        errorView = getLayoutInflater().inflate(R.layout.view_error, rv, false);
        adapter = new SimpleStringAdapter(Cheeses.sCheeseStrings);
        statesRecyclerViewAdapter = new StatesRecyclerViewAdapter(adapter, loadingView, emptyView, errorView);
        rv.setAdapter(statesRecyclerViewAdapter);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
    }

    public void onLoadingClicked(View view) {
        statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_LOADING);
    }

    public void onEmptyClicked(View view) {
        statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_EMPTY);
    }

    public void onErrorClicked(View view) {
        statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_ERROR);
    }

    public void onNormalClicked(View view) {
        statesRecyclerViewAdapter.setState(StatesRecyclerViewAdapter.STATE_NORMAL);
    }
}
