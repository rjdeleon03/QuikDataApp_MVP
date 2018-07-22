package com.icred.quikdata.Repository;

import android.support.annotation.NonNull;

import java.util.List;

/**
 * Main entry point for accessing DNCA Form data
 */
public interface DNCAFormDataSource {

    interface LoadDncaFormsCallback {
//        void onDncaFormsLoaded(List<DNCAListItem> forms);
        void onDncaFormsLoaded(List<Object> forms);

        void onDataNotAvailable();
    }

    interface GetDncaFormCallback {
//        void onDncaFormLoaded(DNCAForm form);
        void onDncaFormLoaded(Object form);

        void onDataNotAvailable();
    }

    interface SubmitDncaFormCallback {
        void onDncaFormSubmitted();
    }

    interface UploadImagesCallback {
        void onImagesUploaded(List<String> images);
    }

    void loadAllDncaForms(@NonNull LoadDncaFormsCallback callback);

    void retrieveNewDncaForm(@NonNull GetDncaFormCallback callback);

    void submitDncaForm(@NonNull SubmitDncaFormCallback callback);

    void uploadImages(@NonNull UploadImagesCallback callback);
}
