package com.ach.androidcertf.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ach.androidcertf.R;

public class ActivityToast extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        setTitle("Toast");

    }

    /**
     * onClick listener for each buttons
     * @param button The clicked button
     */
    @Override
    public void onClick(View button) {
        switch (button.getId()) {
            case R.id.show_toast_button:
                displayToastMessage();
                break;
            case R.id.show_custom_toast_button:
                displayCustomToastMessage();
                break;
        }
    }

    /**
     * Create and display a Toast message
     */
    public void displayToastMessage() {
        String toastMessage = "Hello Toast!";
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();
    }

    /**
     * Create and display a custom Toast message
     */
    private void displayCustomToastMessage() {
        // Setup layout for the custom toast
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));
        ((CardView) layout).setRadius(16);
        ((CardView) layout).setCardBackgroundColor(getResources().getColor(R.color.colorCardBackground));
        TextView text = layout.findViewById(R.id.custom_toast_text);
        text.setText("Hello custom Toast!");

        // Apply custom attributes to the toast object
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}

