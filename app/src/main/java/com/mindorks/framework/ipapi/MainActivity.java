package com.mindorks.framework.ipapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewResult = findViewById(R.id.text_view_result);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ip-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        JSONPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);
        retrofit2.Call<Post> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new retrofit2.Callback<Post>() {
            @Override
            public void onResponse(retrofit2.Call<Post> call, retrofit2.Response<Post> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }
                Post posts = response.body();

                String content = "";
                content += "Country: " + posts.getCountry() + "\n";
                content += "Country Code: " + posts.getCountryCode() + "\n";
                content += "Region Name: " + posts.getRegionName() + "\n";
                content += "Timezone: " + posts.getTimezone() + "\n";

                textViewResult.append(content);
            }

            @Override
            public void onFailure(retrofit2.Call<Post> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}