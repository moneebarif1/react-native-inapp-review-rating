package com.reactnativeinappreviewrating;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = InappReviewRatingModule.NAME)
public class InappReviewRatingModule extends ReactContextBaseJavaModule {
    public static final String NAME = "InappReviewRating";

    public InappReviewRatingModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


     public void createReviewInfo(final Promise promise){
        Task<ReviewInfo> request = manager.requestReviewFlow();
        request.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                // We can get the ReviewInfo object
                reviewInfo = task.getResult();
                promise.resolve("Success");
            } else {
                // There was some problem, log or handle the error code.
                 String reviewErrorCode = task.getException().toString();
                promise.reject("reject", reviewErrorCode);

            }
        });
    }

    public void showInAppReview(final Promise promise){

        if(reviewInfo != null) {
            Task<Void> flow = manager.launchReviewFlow(getCurrentActivity(), reviewInfo);
            flow.addOnCompleteListener(task -> {
                promise.resolve("Done");

            });
        }
    }

  @ReactMethod
    public void requestReviewFlow(final Promise promise) {
        Log.i("Tag", "Inappupdate checkupdate");

        createReviewInfo(promise);
    }

    @ReactMethod
    public void showInAppReviewFlow(final Promise promise) {
        Log.i("Tag", "Inappupdate checkupdate");

        showInAppReview(promise);
    }


}
