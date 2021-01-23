package com.ach.androidcertf.activities;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ach.androidcertf.R;
import com.google.android.material.snackbar.Snackbar;

public class ActivitySnackBar extends AppCompatActivity implements View.OnClickListener {

    View rootView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        setTitle("SnackBar");

        rootView = findViewById(R.id.root_view);

    }


    /**
     * onClick listener for each buttons
     *
     * @param button The clicked button
     */
    @Override
    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.show_snackbar_button:
                showSnackbar();
                break;
            default:

        }
    }

    private void showSnackbar() {
        Snackbar snackbar = Snackbar
                .make(rootView, "Message is deleted", Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(rootView, "Message is restored!", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();
    }


}
