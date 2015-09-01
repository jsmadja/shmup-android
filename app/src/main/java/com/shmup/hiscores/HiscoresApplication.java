package com.shmup.hiscores;

import android.app.Application;

import com.shmup.hiscores.api.ShmupAPI;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import timber.log.Timber;

public class HiscoresApplication extends Application {

    public static ShmupAPI shmupAPI;

    @Override
    public void onCreate() {
        super.onCreate();

        RestAdapter.Builder builder = new RestAdapter.Builder().setClient(new OkClient()).setConverter(new JacksonConverter());
        shmupAPI = builder.setEndpoint(BuildConfig.BASE_URL).build().create(ShmupAPI.class);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
