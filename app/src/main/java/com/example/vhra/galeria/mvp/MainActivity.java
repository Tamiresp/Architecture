package com.example.vhra.galeria.mvp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vhra.galeria.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainActivityPresenter {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    private MainActivityPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainActivityPresenter(this);

        mRecyclerView = findViewById(R.id.recycler_medias);

        presenter.getFilePaths("Download");

    }


    @Override
    public void getFilePaths(List<Media> mMedias) {
        initRecyclerView(mMedias);
    }

    public void initRecyclerView(List<Media> mMedias) {

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MediasAdapter(mMedias);
        mRecyclerView.setAdapter(mAdapter);
    }
}
