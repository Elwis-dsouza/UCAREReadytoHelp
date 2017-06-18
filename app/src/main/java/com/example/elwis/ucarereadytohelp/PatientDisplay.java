package com.example.elwis.ucarereadytohelp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PatientDisplay extends Activity {

    private String URL_NEW_PREDICTION = "http://10.0.2.2/tech/new_predict.php";
    private Button btnAddPrediction;

    String std = "1";
    String coffee = "1";
    String tobacco = "1";
    String alcohol = "1";
    String pret = "1";
    String uriday = "1";
    String blocked = "1";
    String incontinence = "1";
    String urge = "1";
    String rib = "1";
    String smelling = "1";
    String ache ="1";
    String nausea ="1";
    String uti ="1";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_display);

        RadioGroup STD = (RadioGroup) findViewById(R.id.answer1);

        STD.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.answer1A:
                        std = "1";
                        break;
                    case R.id.answer1B:
                        std = "2";
                        break;
                }

            }
        });

        RadioGroup COFFEE = (RadioGroup) findViewById(R.id.answer2);

        COFFEE.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub

                switch (checkedId) {
                    case R.id.answer2A:
                        coffee = "1";
                        break;
                    case R.id.answer2B:
                        coffee = "2";
                        break;
                    case R.id.answer2C:
                        coffee = "3";
                        break;
                    case R.id.answer2D:
                        coffee = "4";
                        break;
                    case R.id.answer2E:
                        coffee = "5";
                        break;

                }
            }
        });

        final RadioGroup tob = (RadioGroup) findViewById(R.id.answer3);

        tob.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer3A:
                        tobacco = "1";
                        break;
                    case R.id.answer3B:
                        tobacco = "2";
                        break;
                    case R.id.answer3C:
                        tobacco = "3";
                        break;
                    case R.id.answer3D:
                        tobacco = "4";
                        break;
                    case R.id.answer3E:
                        tobacco = "5";
                        break;

                }

            }
        });

        RadioGroup acl  = (RadioGroup) findViewById(R.id.answer4);

        acl.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer4A:
                        alcohol = "1";
                        break;
                    case R.id.answer4B:
                        alcohol = "2";
                        break;
                    case R.id.answer4C:
                        alcohol = "3";
                        break;
                    case R.id.answer4D:
                        alcohol = "4";
                        break;
                    case R.id.answer4E:
                        alcohol = "5";
                        break;

                }

            }
        });

        RadioGroup prt  = (RadioGroup) findViewById(R.id.answer5);

        prt.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer5A:
                        pret = "1";
                        break;
                    case R.id.answer5B:
                        pret = "2";
                        break;
                }

            }
        });

        RadioGroup uri  = (RadioGroup) findViewById(R.id.answer6);

        uri.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer6A:
                       uriday  = "1";
                        break;
                    case R.id.answer6B:
                        uriday = "2";
                        break;
                    case R.id.answer6C:
                        uriday  = "1";
                        break;
                    case R.id.answer6D:
                        uriday = "2";
                        break;
                }

            }
        });

        RadioGroup flow  = (RadioGroup) findViewById(R.id.answer7);

        flow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer7A:
                        blocked  = "1";
                        break;
                    case R.id.answer7B:
                        blocked = "2";
                        break;
                }

            }
        });

        RadioGroup in  = (RadioGroup) findViewById(R.id.answer8);

        in.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer8A:
                        incontinence  = "1";
                        break;
                    case R.id.answer8B:
                        incontinence = "2";
                        break;
                }

            }
        });

        RadioGroup stg  = (RadioGroup) findViewById(R.id.answer9);

        stg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer9A:
                        urge  = "1";
                        break;
                    case R.id.answer9B:
                        urge = "2";
                        break;
                }

            }
        });

        RadioGroup back  = (RadioGroup) findViewById(R.id.answer10);

        back.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer10A:
                        rib  = "1";
                        break;
                    case R.id.answer10B:
                        rib = "2";
                        break;
                }

            }
        });

        RadioGroup dark  = (RadioGroup) findViewById(R.id.answer11);

        dark.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer11A:
                        smelling  = "1";
                        break;
                    case R.id.answer11B:
                        smelling = "2";
                        break;
                }

            }
        });

        RadioGroup feel  = (RadioGroup) findViewById(R.id.answer12);

        feel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer12A:
                         ache = "1";
                        break;
                    case R.id.answer12B:
                        ache = "2";
                        break;
                }

            }
        });

        RadioGroup sfr  = (RadioGroup) findViewById(R.id.answer13);

        sfr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer13A:
                       nausea  = "1";
                        break;
                    case R.id.answer13B:
                        nausea = "2";
                        break;
                }

            }
        });

        RadioGroup did  = (RadioGroup) findViewById(R.id.answer14);

        did.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                switch (checkedId) {
                    case R.id.answer14A:
                        uti  = "1";
                        break;
                    case R.id.answer14B:
                        uti = "2";
                        break;
                }

            }
        });

        btnAddPrediction = (Button) findViewById(R.id.submit);

        btnAddPrediction.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                new AddNewPrediction().execute(std,coffee,tobacco,alcohol,pret,uriday,blocked,incontinence,urge,rib,
                    smelling,ache,nausea,uti);
            }

        });

    }

   // @Override
  //  public boolean onCreateOptionsMenu(Menu menu) {
     //   getMenuInflater().inflate(R..activity_patient_display, layout);
     //   return true;
   // }

    private class AddNewPrediction extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(String... arg) {
            // TODO Auto-generated method stub
            String trns = arg[0];
            String cofe = arg[1];
            String tbc = arg[2];
            String alc = arg[3];
            String prt = arg[4];
            String urd = arg[5];
            String blk = arg[6];
            String inc = arg[7];
            String urg = arg[8];
            String ribs = arg[9];
            String smel = arg[10];
            String ach = arg[11];
            String nau = arg[12];
            String ut = arg[13];

            // Preparing post params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("trns", trns));
            params.add(new BasicNameValuePair("cofe", cofe));
            params.add(new BasicNameValuePair("tbc", tbc));
            params.add(new BasicNameValuePair("alc", alc));
            params.add(new BasicNameValuePair("prt", prt));
            params.add(new BasicNameValuePair("urd", urd));
            params.add(new BasicNameValuePair("blk", blk));
            params.add(new BasicNameValuePair("inc", inc));
            params.add(new BasicNameValuePair("urg", urg));
            params.add(new BasicNameValuePair("ribs", ribs));
            params.add(new BasicNameValuePair("smel", smel));
            params.add(new BasicNameValuePair("ach", ach));
            params.add(new BasicNameValuePair("nau", nau));
            params.add(new BasicNameValuePair("ut", ut));












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