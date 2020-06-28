package com.example.angao;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyService extends Service {
    public MyService() {
    }

    private static final String TAG = "MyService";

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
initDownLoad();
        return super.onStartCommand(intent, flags, startId);
    }

    private void initDownLoad() {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://alissl.ucdl.pp.uc.cn/fs08/2019/07/05/1/110_17e4089aa3a4b819b08069681a9de74b.apk")
                .build();
        okHttpClient.newCall(request)
                .enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e(TAG, "onFailure: 服务中下载=" + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        InputStream inputStream = response.body().byteStream();
                        long contentLength = response.body().contentLength();
                        String s = Environment.getExternalStorageDirectory() + "/abc.apk";
                        File file = new File(s);
                        if (!file.exists()) {
                            file.createNewFile();
                        }

                        FileOutputStream outputStream = new FileOutputStream(file);

                        int readLength;
                        long currLength = 0;
                        byte[] bytes = new byte[1024 * 4];

                        while ((readLength = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, readLength);
                            currLength += readLength;

                            int progress = (int) (currLength * 100 / contentLength);
                            Log.e(TAG, "onResponse: " + progress + "%");
                        }
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ==================" );
    }
}
