package com.example.elwis.ucarereadytohelp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class SecondActivity extends AppCompatActivity implements View.OnClickListener {


    final String LOG = "SecondActivity";
    Button btnCheck;
    EditText etDrugname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btnCheck = (Button) findViewById(R.id.btnCheck);
        etDrugname = (EditText) findViewById(R.id.etDrugname);
        btnCheck.setOnClickListener(this);
    }

    @Override
            public void onClick(View v) {
                HashMap<String, String> postData = new HashMap<>();
                final String Drugname = etDrugname.getText().toString();
                final Post Referenceid = new Post();
               Referenceid.setReference("$resistance_ref", Referenceid);
               postData.put("txtDrugname", Drugname);


        PostResponseAsyncTask task1 = new PostResponseAsyncTask(SecondActivity.this, postData,
                        new AsyncResponse() {
                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);
                                try {
                                    JSONObject jsonObject = new JSONObject(s);
                                    if(jsonObject.getString("status").equals("Drug Found")) {//(s.contains("Drug Not found")) {
                                        //Toast.makeText(SecondActivity.this, "Drug Successfully found", Toast.LENGTH_LONG).show();
                                        Intent intent = new Intent(SecondActivity.this, DisplayActivity.class);
                                        intent.putExtra("Drugname", etDrugname.getText().toString());
                                        intent.putExtra("Referenceid", Referenceid);
                                        intent.putExtra("pmid", jsonObject.getJSONArray("status").toString());
                                        startActivity(intent);

                                    } else {
                                        Toast.makeText(SecondActivity.this, "Something went wrong", Toast.LENGTH_LONG).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                task1.execute("http://www.e-bioinformatics.net/db/utipedia/test/login2.php");
            }
        }





