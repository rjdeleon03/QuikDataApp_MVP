package com.icred.quikdata;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class QuikDataApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("quikdata.realm")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}
