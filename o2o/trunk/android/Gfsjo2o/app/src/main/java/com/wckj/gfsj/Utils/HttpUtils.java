package com.wckj.gfsj.Utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wckj.gfsj.Application.AppApplication;
import com.wckj.gfsj.Bean.Base.BaseRequest;
import com.wckj.gfsj.Utils.IImpl.ICallBack;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/29.
 */
public class HttpUtils {
    private HttpUtils(){}
    private static HttpUtils instance;
    private  static OkHttpClient client ;
     public static HttpUtils getInstance(){
         if(instance==null){
             instance=new HttpUtils();
         }
         if(client==null){
             client = new OkHttpClient();
         }
         return instance;
     }

    public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");



    /**
     * 同步POST请求
     * @param appRequest
     * @param url
     * @param clazz 返回类型，如登录使用LoginResult.class
     * @param <T>
     * @return
     * @throws IOException
     */
    public  <T> T syncPost(BaseRequest appRequest, String url, Class<T> clazz) throws IOException {
        String jsonStr = JSON.toJSONString(appRequest);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return JSON.parseObject(response.body().string(), clazz);
        } else {
            throw new IOException("Network error: " + response);
        }
    }

    /**
     * 异步POST请求，实际使用需要根据情况传入Handler用于回调
     * @param appRequest
     * @param url
     */
    public  void asyncPost(BaseRequest appRequest, String url, final ICallBack callBack) {
        if(AppApplication.loginResult!=null){
            if(AppApplication.loginResult.getToken()!=null){
                appRequest.setToken(AppApplication.loginResult.getToken());
            }
            appRequest.setDeviceId(AppApplication.loginResult.getDeviceId());
        }

        String jsonStr = JSON.toJSONString(appRequest, SerializerFeature.WriteMapNullValue);
        RequestBody body = RequestBody.create(JSON_TYPE, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onError(call,e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
              String str=  response.body().string();
                LogTools.println(null,"===="+str);
                callBack.onSuccess(str);
            }
       });
    }

}
