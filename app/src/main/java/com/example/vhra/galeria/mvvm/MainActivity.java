package com.example.vhra.galeria.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vhra.galeria.R;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyViewModel viewModel;

    List<Media> medias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_medias);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MediasAdapter(medias);
        mRecyclerView.setAdapter(mAdapter);

        initViewModel();

        viewModel.getFilePaths("Download").observe(this, media -> {
            notify(medias);
        });
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);
    }

    private void notify(List<Media> media){
        medias = media;
    }
}