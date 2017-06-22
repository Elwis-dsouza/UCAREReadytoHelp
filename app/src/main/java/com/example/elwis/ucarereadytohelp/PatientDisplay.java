package com.example.elwis.ucarereadytohelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class PatientDisplay extends Activity implements View.OnClickListener {

    final String LOG = "PatientDisplay";
    //private String URL_NEW_PREDICTION = "http://www.e-bioinformatics.net/db/utipedia/test/pateint.php";
    private Button btnAddPrediction;

    String blocked = "1";
    String smelling = "1";
    String nausea = "1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_display);


        RadioGroup Blocked = (RadioGroup) findViewById(R.id.answer1);

        Blocked.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.answer1A:
                        blocked = "1";
                        break;
                    case R.id.answer1B:
                        blocked = "2";
                        break;
                }

            }
        });

        RadioGroup Smelling = (RadioGroup) findViewById(R.id.answer2);

        Smelling.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.answer2A:
                        blocked = "1";
                        break;
                    case R.id.answer2B:
                        blocked = "2";
                        break;

                }
            }
        });

        final RadioGroup Nausea = (RadioGroup) findViewById(R.id.answer3);

        Nausea.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer3A:
                        nausea = "1";
                        break;
                    case R.id.answer3B:
                        nausea = "2";
                        break;

                }


            }
        });


        btnAddPrediction = (Button) findViewById(R.id.submit);

        btnAddPrediction.setOnClickListener(this);}


        public void onClick(View v) {

        List<NameValuePair> params = new ArrayList<>();
        String block = blocked;
        String smell = smelling;
        String nau = nausea;
        params.add(new BasicNameValuePair("block", block));
        params.add(new BasicNameValuePair("smell", smell));
        params.add(new BasicNameValuePair("nau", nau));


        PostResponseAsyncTask task1 = new PostResponseAsyncTask(PatientDisplay.this,
                new AsyncResponse() {
                    @Override
                    public void processFinish(String s) {
                        Log.d(LOG, s);
                        if (s.contains("Your Chances of UTI is predominant!")) {
                            //Toast.makeText(SecondActivity.this, "Drug Successfully found", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(PatientDisplay.this, DisplayActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(PatientDisplay.this, "It seems you are safe.", Toast.LENGTH_LONG).show();
                        }

                    }
                });
            task1.execute("http://www.e-bioinformatics.net/db/utipedia/test/login2.php");
    }}

