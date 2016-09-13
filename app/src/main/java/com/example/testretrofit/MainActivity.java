package com.example.testretrofit;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ActionBarActivity {
    private TextView name;
    private TextView age;
    private final String TAG = "network";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (TextView) findViewById(R.id.name);
        age = (TextView) findViewById(R.id.age);

        // getTest();
        //createPerson();
        getUsers();
    }

    /**
     * 测试Get请求
     */
    private void getTest() {
        Call<String> call = RetroFactory.getStringService().getTest();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful() && response.errorBody() == null) {
                    Log.d(TAG, "str:" + response.body().toString());
                } else {
                    Log.d(TAG, "error code:" + response.code());
                    Log.d(TAG, "error message:" + response.message());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "error:" + t.getMessage());
            }
        });
    }

    /**
     * 测试POST请求
     */
    private void createPerson() {
        Call<Void> call = RetroFactory.getStringService().createPerson("gesanri", "10");
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }

    private void getUsers() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("key", "PC");
        map.put("uuid", "Ah2FetfuAIlykvTRefHBJzzEZ_Ex8QnDdfkBr3IezHSR");

        new BaseTask<Person>(this,RetroFactory.getJsonService().getUsers(map)).handleResponse(new BaseTask.ResponseListener<Person>() {
            @Override
            public void onSuccess(Person person) {
                Log.d(TAG, "onSuccess: "+person.getData().get(0).getUrl());
            }
        });
    }
}
