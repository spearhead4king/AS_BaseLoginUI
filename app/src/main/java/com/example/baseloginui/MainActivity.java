package com.example.baseloginui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 按钮点击时根据输入框内容判断是否可以登录
        Button button_login = findViewById(R.id.login);
        button_login.setOnClickListener(v -> {
            String username = ((EditText) findViewById(R.id.username)).getText().toString();
            String password = ((EditText) findViewById(R.id.password)).getText().toString();
            TextView tip = findViewById(R.id.tip);
            // 如果登录成功tip显示登录成功，否则显示登录失败
            if (UserData.check(username, password)) {
                tip.setText("登录成功");
            } else {
                tip.setText("用户名或密码错误");
            }

            tip.setVisibility(TextView.VISIBLE);
        });
    }
}