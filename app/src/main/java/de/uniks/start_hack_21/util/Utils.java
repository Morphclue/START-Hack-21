package de.uniks.start_hack_21.util;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

import de.uniks.start_hack_21.data.User;

public class Utils {
    static String getJsonFromAssets(Context context, String fileName) {
        String jsonString;
        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

    public static User loadData(Context context){
        String jsonFileString = getJsonFromAssets(context, "test_data.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        User user = gson.fromJson(jsonFileString, User.class);
        Log.i("data", '\n' + gson.toJson(user));
        return user;
    }

}

