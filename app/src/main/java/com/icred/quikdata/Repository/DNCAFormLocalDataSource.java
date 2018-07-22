package com.icred.quikdata.Repository;

import android.support.annotation.NonNull;

public class DNCAFormLocalDataSource implements DNCAFormDataSource {

    private static volatile DNCAFormLocalDataSource INSTANCE;

    private DNCAFormLocalDataSource() {

    }

    public static DNCAFormLocalDataSource newInstance() {
        if(INSTANCE == null) {
            INSTANCE = new DNCAFormLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback) {

    }

    @Override
    public void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback) {

    }

    @Override
    public void submitDncaForm(@NonNull SubmitDncaFormCallback callback) {

    }

    @Override
    public void uploadImages(@NonNull UploadImagesCallback callback) {

    }
}
