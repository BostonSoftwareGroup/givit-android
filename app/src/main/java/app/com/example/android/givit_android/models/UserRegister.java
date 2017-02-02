package app.com.example.android.givit_android.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
        LinkedTreeMap<String, String> name = new LinkedTreeMap<String, String>();
        name.put("username", userEmail);
        LinkedTreeMap<String, String> password = new LinkedTreeMap<String, String>();
        password.put("userpassword", userPassword);

        this.params.add(name);
        this.params.add(password);
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
