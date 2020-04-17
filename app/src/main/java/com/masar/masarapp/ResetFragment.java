package com.masar.masarapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetFragment extends Fragment implements View.OnClickListener {

    Context mContext;

    private EditText mReset;
    private Button mBtnReset;

    private FirebaseAuth auth;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_reset, container, false);


        mReset = view.findViewById(R.id.et_reset_email);

        mBtnReset = view.findViewById(R.id.btn_reset);
        mBtnReset.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View view) {
        String email = mReset.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getActivity(), "Enter your registered email", Toast.LENGTH_SHORT).show();
            return;
        }

        auth = FirebaseAuth.getInstance();
        auth.sendPasswordResetEmail(email)

                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getActivity(), "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                            getActivity().getSupportFragmentManager().beginTransaction().remove(ResetFragment.this).commit();

                        } else {
                            Toast.makeText(mContext, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }


}
