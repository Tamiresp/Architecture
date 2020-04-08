package com.example.vhra.galeria.mvp;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivityPresenter {

    IMainActivityPresenter view;

    public MainActivityPresenter(IMainActivityPresenter view) {
        this.view = view;
    }

    public static final List<String> FILE_EXTENSIONS = Arrays.asList("jpg", "jpeg", "png");

    public void getFilePaths(String dir) {
        List<Media> medias = new ArrayList<>();

        File directory = new File(android.os.Environment.getExternalStorageDirectory() + File.separator + dir);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                String filePath = file.getAbsolutePath();
                if (isSupportedFile(filePath)) {
                    medias.add(new Media(filePath));
                }
            }
        }
        view.getFilePaths(medias);
    }

    private boolean isSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1), filePath.length());
        return FILE_EXTENSIONS.contains(ext.toLowerCase(Locale.getDefault()));
    }

    public int countMedias(){
        List<Media> medias = new ArrayList<>();
        return medias.size();
    }
}