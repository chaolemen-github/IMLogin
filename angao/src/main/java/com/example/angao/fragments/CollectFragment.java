package com.example.angao.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.angao.MyService;
import com.example.angao.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment {
    private static final String TAG = "CollectFragment";

    @BindView(R.id.btn_collect_downLoad)
    Button btnCollectDownLoad;
    Unbinder unbinder;
    private MyService myService;
    private Intent intent;

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_collect, container, false);
        unbinder = ButterKnife.bind(this, inflate);
//        initDownLoad();
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (intent!=null){
            getActivity().stopService(intent);
        }
    }

    @OnClick(R.id.btn_collect_downLoad)
    public void onViewClicked() {
//        myService = new MyService();
        intent = new Intent(getActivity(), MyService.class);
        getActivity().startService(intent);

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

                            int progress = (int) (contentLength * 100 / contentLength);
                            Log.e(TAG, "onResponse: " + progress + "%");
                        }
                    }
                });
    }

}
