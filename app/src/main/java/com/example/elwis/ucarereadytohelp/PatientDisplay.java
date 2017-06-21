package com.example.elwis.ucarereadytohelp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class PatientDisplay extends Activity {

    private String URL_NEW_PREDICTION = "http://10.0.2.2/tech/new_predict.php";
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

        btnAddPrediction.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                new AddNewPrediction().execute(blocked,smelling,nausea);
            }

        });

    }

    private class AddNewPrediction extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... arg) {
            // TODO Auto-generated method stub
            String block = arg[0];
            String smell = arg[1];
            String nau = arg[2];
            // Preparing post params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("block", block));
            params.add(new BasicNameValuePair("smell", smell));
            params.add(new BasicNameValuePair("nau", nau));


            ServiceHandler serviceClient = new ServiceHandler();

            String json = serviceClient.makeServiceCall(URL_NEW_PREDICTION,
                    ServiceHandler.POST, params);

            Log.d("Create Prediction: ", "> " + json);

            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    boolean error = jsonObj.getBoolean("error");
                    // checking for error node in json
                    if (!error) {
                        // new category created successfully
                        Log.e("Added successfully ",
                                "> " + jsonObj.getString("message"));
                    } else {
                        Log.e("Add Prediction Error: ",
                                "> " + jsonObj.getString("message"));
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("JSON Data", "JSON data error!");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
        }
    }
}