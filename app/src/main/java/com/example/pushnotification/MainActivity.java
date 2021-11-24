package com.example.pushnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.Utils;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String firebaseToken = "";
    private ApiInstance apiInstance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        FirebaseMessaging.getInstance().subscribeToTopic("atschool")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Done";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Log.d("error", msg);
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });

       // FirebaseMessaging.getInstance().subscribeToTopic("atschool");

       /* apiInstance = RetrofitInstance.getRetrofitInstance().create(ApiInstance.class);

        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("mobile_no","01755590672");
        jsonObject.addProperty("device_code",firebaseToken);
        Log.e("jsonObject", "getData: "+jsonObject.toString() );
        apiInstance.getData(jsonObject).enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    Log.e("success", "onFailure: success" );
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "onFailure: "+t.getLocalizedMessage() );

            }
        });*/




    }

    /*private void getData(String s, String firebaseToken) {
        apiInstance = RetrofitInstance.getRetrofitInstance().create(ApiInstance.class);

        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("mobile_no","01755590672");
        jsonObject.addProperty("device_code","erS27h6VTaCpUvg5NLBpi1:APA91bHcP7YaJb2Vy497aiek9LvF0HFnz67jSdgS7ac1JSFyuAh6KPlFtpVzcVPwjTHyuOCgKZl8nHy89EuzH8ySfxe0wMp5I-Ew0GO49r0KFsDCmw8QaC92gzVDv2YmgZ19o4tr-qpW");
        Log.e("jsonObject", "getData: "+jsonObject.toString() );
        apiInstance.getData(jsonObject).enqueue(new Callback<TokenModel>() {
            @Override
            public void onResponse(Call<TokenModel> call, Response<TokenModel> response) {
                if(response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "success", Toast.LENGTH_SHORT).show();
                    Log.e("success", "onFailure: success" );
                }
            }

            @Override
            public void onFailure(Call<TokenModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("onFailure", "onFailure: "+t.getLocalizedMessage() );

            }
        });

    }*/

}