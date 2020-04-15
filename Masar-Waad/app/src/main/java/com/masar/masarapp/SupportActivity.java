package com.masar.masarapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SupportActivity extends AppCompatActivity {

    public static final String EMAIL = "masar.track@outlook.com";

    EditText mSubject, mSupportProblem;
    Button mBtnSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.support);

        mSubject = findViewById(R.id.et_Subject);
        mSupportProblem = findViewById(R.id.supportProblemEditText);

        mBtnSend = findViewById(R.id.supportSendButton);

        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String subject = mSubject.getText().toString().trim();
                String feedback = mSupportProblem.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{EMAIL});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, feedback);
                startActivity(Intent.createChooser(intent, "Choose an application"));

                mSubject.setText("");
                mSupportProblem.setText("");

            }
        });

    }

}
