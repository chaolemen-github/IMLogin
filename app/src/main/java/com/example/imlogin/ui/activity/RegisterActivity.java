package com.example.imlogin.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.imlogin.R;
import com.example.imlogin.base.BaseActivity;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.register_user)
    EditText registerUser;
    @BindView(R.id.register_pass)
    EditText registerPass;
    @BindView(R.id.btn_im_register)
    Button btnImRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }


    @OnClick(R.id.btn_im_register)
    public void onViewClicked() {
        String user = registerUser.getText().toString();
        String pass = registerPass.getText().toString();
        initRegister(user,pass);
    }

    private void initRegister(String user, String pass) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(user, pass);//同步方法
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.putExtra("user",user);
                            intent.putExtra("pass",pass);
                            setResult(300,intent);
                            finish();
                        }
                    });
                } catch (HyphenateException e) {
                    Log.e("TAG", "run: 注册" +e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
