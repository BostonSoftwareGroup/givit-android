package app.com.example.android.givit_android.net;

import app.com.example.android.givit_android.models.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//endpoints defined inside of interface using annotation
//returned value is always a parameterized Call<T> object such as Call<User>
public interface GivitApi {
    //examples:
    @GET("/items/{id}")
    Call<Response> getAllItems(
       @Path("id") String id
    );
}
