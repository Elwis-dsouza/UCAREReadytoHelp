package com.example.elwis.ucarereadytohelp;

//import android.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Display2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydisplay);

        TextView nameView = (TextView) findViewById(R.id.result1);
        nameView.setText(getIntent().getExtras().getString("Drugname"));

    }
}
