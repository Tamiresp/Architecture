package com.example.vhra.galeria.mvvm;

public class Media {

    private String mThumbnailLocalPath;

    public Media(String thumbnail) {
        mThumbnailLocalPath = thumbnail;
    }

    public String getThumbnailLocalPath() {
        return mThumbnailLocalPath;
    }
}