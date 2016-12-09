package app.com.example.android.givit_android.models;


public class Response {
    String userEmail;
    String userPassword;
    String responseCode;

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getResponseCode() {
        return responseCode;
    }
}
