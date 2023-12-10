package com.example.mohamedalibourilsi3_tp2.Controller;

import android.content.Context;
import android.content.SharedPreferences;
public class LoginC {
    private static final String PREF_NAME = "UserPreferences";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static LoginC instance;
    private String username;
    private String password;
    private LoginC() {
        // Private constructor to enforce Singleton pattern
    }
    public void createUser(String userName, String password, Context context) {
        this.username = userName;
        this.password = password;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USERNAME, userName);
        editor.putString(KEY_PASSWORD, password);
        editor.apply();
    }
    public static void recapUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        instance.username = sharedPreferences.getString(KEY_USERNAME, null);
        instance.password = sharedPreferences.getString(KEY_PASSWORD, null);
    }
}
