package de.uniks.start_hack_21.services;

import com.google.gson.internal.$Gson$Preconditions;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    private String apiKey = "WJpDAQqpIbZNa7ANLrlZIzShYYUszrfRNMbdjQv6g66RdW1JLaVAaQ==";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
       Request newRequest =  oldRequest.
               newBuilder().
               headers(oldRequest.headers()).addHeader("x-functions-key", apiKey).
               method(oldRequest.method(),oldRequest.body()).
               build();
       return chain.proceed(newRequest);
    }
}
