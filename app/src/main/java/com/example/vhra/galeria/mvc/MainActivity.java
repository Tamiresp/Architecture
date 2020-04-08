package com.example.vhra.galeria.mvc;

import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vhra.galeria.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.example.vhra.galeria.mvc.MainActivity.MediasAdapter.FILE_EXTENSIONS;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Media> medias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_medias);

        medias  = getFilePaths("Download");

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MediasAdapter(medias);
        mRecyclerView.setAdapter(mAdapter);
    }

    static public class MediasAdapter extends RecyclerView.Adapter<MediasAdapter.MediaViewHolder> {

        private  List<Media> mMedias;
        public static final List<String> FILE_EXTENSIONS =  Arrays.asList("jpg", "jpeg", "png");
        public MediasAdapter(List<Media> mediaList) {
            mMedias = mediaList;
        }

        @NonNull
        @Override
        public MediasAdapter.MediaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(
                    viewGroup.getContext()).inflate(R.layout.item_view_gallery, viewGroup, false);
            return new MediasAdapter.MediaViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MediasAdapter.MediaViewHolder mediaViewHolder, int i) {
            Media media = mMedias.get(i);
            mediaViewHolder.imageViewThumbnail.setImageURI(Uri.fromFile(new File(media.getThumbnailLocalPath())));
        }

        @Override
        public int getItemCount() {
            return mMedias != null ? mMedias.size() : 0;
        }

        public static class MediaViewHolder extends RecyclerView.ViewHolder {
            ImageView imageViewThumbnail;
            public MediaViewHolder(View viewRoot) {
                super(viewRoot);
                imageViewThumbnail = itemView.findViewById(R.id.image_media_thumbnail);
            }
        }
    }

    public List<Media> getFilePaths(String dir) {
        List<Media> medias = new ArrayList<>();

        File directory = new File(android.os.Environment.getExternalStorageDirectory() + File.separator  + dir);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                String filePath = file.getAbsolutePath();
                if (isSupportedFile(filePath)) {
                    medias.add(new Media(filePath));
                }
            }
        }

        return medias;
    }

    private boolean isSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1), filePath.length());
        return FILE_EXTENSIONS.contains(ext.toLowerCase(Locale.getDefault()));
    }
}
