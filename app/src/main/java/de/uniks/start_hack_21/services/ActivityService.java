package de.uniks.start_hack_21.services;

import android.app.Activity;

import java.util.List;

import de.uniks.start_hack_21.data.ActivityResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ActivityService {
    @GET("activities")
    Call<List<ActivityResponse>> getActivities(@Query("userId") String userId);
}
