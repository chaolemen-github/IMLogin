package com.example.imlogin.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imlogin.R;
import com.example.imlogin.utils.SharedPreferencesUtils;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mUserIm;
    private EditText mPassIm;
    private Button mLoginBtn;
    private Button mUnLoginBtn;
    private Button mRegisterBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mUserIm = (EditText) findViewById(R.id.im_user);
        mPassIm = (EditText) findViewById(R.id.im_pass);
        mLoginBtn = (Button) findViewById(R.id.btn_login);
        mLoginBtn.setOnClickListener(this);
        mUnLoginBtn = (Button) findViewById(R.id.btn_unLogin);
        mUnLoginBtn.setOnClickListener(this);
        mRegisterBtn = (Button) findViewById(R.id.btn_register);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                // TODO 20/06/10
                initLogin();
                break;
            case R.id.btn_unLogin:
                // TODO 20/06/10
                initUnLogin();
                break;
            case R.id.btn_register:
                // TODO 20/06/10
                startActivityForResult(new Intent(LoginActivity.this, RegisterActivity.class), 200);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == 300) {
            String user = data.getStringExtra("user");
            String pass = data.getStringExtra("pass");
            mUserIm.setText(user);
            mPassIm.setText(pass);
        }
    }

    private void initUnLogin() {
        EMClient.getInstance().logout(true, new EMCallBack() {

            @Override
            public void onSuccess() {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgress(int progress, String status) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onError(int code, String message) {
                // TODO Auto-generated method stub

            }
        });
    }

    private void initLogin() {
        String user = mUserIm.getText().toString();
        String pass = mPassIm.getText().toString();
//        if (!TextUtils.isEmpty(user)||!TextUtils.isEmpty(pass)){
        EMClient.getInstance().login(user, pass, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                Log.e("main", "登录聊天服务器成功！");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "登录聊天服务器成功", Toast.LENGTH_SHORT).show();
                        SharedPreferencesUtils.setParam(LoginActivity.this,"data",user);
//                        initSharedPreferences(user,pass);
                        startActivity(new Intent(LoginActivity.this,MainActivity.class));
                        finish();
                    }
                });

            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                Log.e("main", "登录聊天服务器失败！"+message);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(LoginActivity.this, "登录聊天服务器失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
//        }
    }

    private void initSharedPreferences(String user, String pass) {
        SharedPreferences sp = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("user",user);
        edit.putString("pass",pass);
        edit.commit();
    }


}
