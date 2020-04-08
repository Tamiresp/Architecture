package com.example.vhra.galeria.mvp;

public class Media {

    private String mThumbnailLocalPath;

    public Media(String thumbnail) {
        mThumbnailLocalPath = thumbnail;
    }

    public String getThumbnailLocalPath() {
        return mThumbnailLocalPath;
    }
}