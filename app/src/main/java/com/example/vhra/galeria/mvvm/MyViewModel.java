package com.example.vhra.galeria.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MyViewModel extends ViewModel {
    public static final List<String> FILE_EXTENSIONS =  Arrays.asList("jpg", "jpeg", "png");

    private MutableLiveData<Media> livedata = new MutableLiveData();

    private MutableLiveData<Media> getMedia(){
        return livedata;
    }

    public List<Media> getFilePaths(String dir) {
        List<Media> medias = new ArrayList<>();

        File directory = new File(android.os.Environment.getExternalStorageDirectory() + File.separator  + dir);
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                String filePath = file.getAbsolutePath();
                if (isSupportedFile(filePath)) {
                    medias.add(new Media(filePath));
                    livedata.setValue(new Media(filePath));
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
