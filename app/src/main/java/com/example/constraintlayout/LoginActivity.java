package com.example.constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        // Find the views
        EditText inputUsername = findViewById(R.id.inputUsername);
        EditText inputEmail = findViewById(R.id.inputEmail);
        Button btnLogin = findViewById(R.id.btnlogin);
        TextView textViewUserName = findViewById(R.id.textViewUserName);
        TextView textView2 = findViewById(R.id.textView2);
        TextView btnSignUp = findViewById(R.id.textViewSignUp);

        // Set onClickListener for Sign Up TextView
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        // Set onClickListener for Login Button
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get input data from EditTexts
                String username = inputUsername.getText().toString();
                String email = inputEmail.getText().toString();

                // Display the input data in the TextViews
                textViewUserName.setText(username);
                textView2.setText(email);
            }
        });

        // Handle window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
