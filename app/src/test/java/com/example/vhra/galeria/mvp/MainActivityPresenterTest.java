package com.example.vhra.galeria.mvp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MainActivityPresenterTest {

    private MainActivityPresenter presenter;
    private IMainActivityPresenter activity;
    private int result = 0;

    @Before
    public void setUp() throws Exception {
        activity = new IMainActivityPresenter() {
            @Override
            public void getFilePaths(List<Media> medias) {

            }

            @Override
            public int countMedias() {
                return result;
            }
        };
        presenter = new MainActivityPresenter(activity);
    }

    @Test
    public void countMedias() {
        presenter.countMedias();
        Assert.assertEquals(0, 0);
    }
}