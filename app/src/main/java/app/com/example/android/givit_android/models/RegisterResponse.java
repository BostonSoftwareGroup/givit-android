package app.com.example.android.givit_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class RegisterResponse implements Serializable{
    @SerializedName("code")
    @Expose
    String code;
    @SerializedName("message")
    @Expose
    String message;
    @SerializedName("body")
    @Expose
    Object body;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
