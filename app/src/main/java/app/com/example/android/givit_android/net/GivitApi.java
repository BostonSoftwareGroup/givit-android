package app.com.example.android.givit_android.net;

import app.com.example.android.givit_android.models.RegisterResponse;
import app.com.example.android.givit_android.models.UserRegister;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

//endpoints defined inside of interface using annotation
//returned value is always a parameterized Call<T> object such as Call<User>
public interface GivitApi {
    @POST("register")
    Call<RegisterResponse> createUser(@Body UserRegister userRegister);

    @POST("sign-in")
    Call<RegisterResponse> signInUser(@Body UserRegister user);
}
