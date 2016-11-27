package app.com.example.android.givit_android.models;

import com.google.gson.Gson;

import java.util.Objects;

public class APIResponse {
    private String code;
    private String message;
    private Object body;

    public APIResponse(){
        super();
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    public void setBody(Objects body){
        this.body = body;
    }
    public Object getBody(){
        return this.body;
    }

    public static APIResponse parse(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, APIResponse.class);
    }
}
