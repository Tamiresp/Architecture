package com.example.vhra.galeria.mvc;

import com.example.vhra.galeria.mvp.IMainActivityPresenter;
import com.example.vhra.galeria.mvp.MainActivityPresenter;
import com.example.vhra.galeria.mvp.Media;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MediaTest {
    private com.example.vhra.galeria.mvc.Media media;
    private Boolean result = false;

    @Before
    public void setUp() throws Exception {
        media = new com.example.vhra.galeria.mvc.Media("Teste");
        if (media.getThumbnailLocalPath() != ""){
            result = true;
        }
    }


    @Test
    public void getThumbnailLocalPath() {
        Assert.assertTrue(result);
    }
}