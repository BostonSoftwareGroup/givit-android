package app.com.example.android.givit_android.net;


import java.io.IOException;

import app.com.example.android.givit_android.ApplicationConstants;
import app.com.example.android.givit_android.models.RegisterResponse;
import app.com.example.android.givit_android.models.UserRegister;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GivitRetrofitService {
    public static GivitApi retrofitInterface;
    private static OkHttpClient okHttpClient;

    public GivitRetrofitService() {
        okHttpClient = buildOkHttpClient();
        initialize(ApplicationConstants.GIVIT_BASE_URL);
    }

    public void initialize(String url) {
        Retrofit preztoRetroFit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        retrofitInterface = preztoRetroFit.create(GivitApi.class);
    }

    private OkHttpClient buildOkHttpClient() {
        OkHttpClient.Builder givitClient = new OkHttpClient.Builder();
        givitClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .method(original.method(), original.body())
                        .build();
                
                return chain.proceed(request);
            }
        });
        return givitClient.build();
    }

    public void createUser(Callback<RegisterResponse> registerCallback, UserRegister userRegister) {
        retrofitInterface.createUser(userRegister).enqueue(registerCallback);
    }

    public void signInUser(Callback<RegisterResponse> signInCallback, UserRegister user) {
        retrofitInterface.signInUser(user).enqueue(signInCallback);
    }
}
