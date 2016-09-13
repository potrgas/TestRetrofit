package com.example.testretrofit;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaseTask<T extends BaseEntity> {
    private Call<T> mCall;
    private Context mContext;
    private final int SUCCESS = 200; //请求成功
    private final int SSO = 300; //账号在异地登录，客户端需要单点登录的情况下需要处理此业务
    private final String TAG = "response";

    public BaseTask(Context context, Call call) {
        mCall = call;
        mContext = context;
    }

    public void handleResponse(final ResponseListener<T> listener) {
        mCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                if (response.isSuccessful() && response.errorBody() == null) {
                    if (response.body().getCode() == SUCCESS) {
                        listener.onSuccess((T) response.body());
                    } else {
                        Toast.makeText(mContext, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Log.d(TAG, "error code:" + response.code()+"error message:" + response.message());
                    Toast.makeText(mContext, "网络请求返回异常！", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                Log.d(TAG, "error:" + t.getMessage());
                Toast.makeText(mContext, "网络请求出现异常！", Toast.LENGTH_LONG).show();
            }
        });
    }

    public interface ResponseListener<T> {
        void onSuccess(T t);
    }
}
