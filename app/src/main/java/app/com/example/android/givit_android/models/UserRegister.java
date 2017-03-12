package app.com.example.android.givit_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRegister implements Serializable{
    @SerializedName("apiKey")
    @Expose
    String apiKey;
    @SerializedName("operator")
    @Expose
    String operator;
    @SerializedName("token")
    @Expose
    String token;
    @SerializedName("params")
    @Expose
    List params = new ArrayList<>();

    public UserRegister(String userEmail, String userPassword) {
        Map<String, String> userInfo = new HashMap<String, String>();
        userInfo.put("username", userEmail);
        userInfo.put("password", userPassword);

        this.params.add(userInfo);
        this.apiKey = "test";
        this.operator = "test";
        this.token = "test";
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<LinkedTreeMap<String, String>> getParams() {
        return params;
    }

    public void setParams(List params) {
        this.params = params;
    }
}
