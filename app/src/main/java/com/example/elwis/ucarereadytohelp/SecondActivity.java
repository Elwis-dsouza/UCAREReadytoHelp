package com.example.elwis.ucarereadytohelp;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.Reference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static com.example.elwis.ucarereadytohelp.R.id.PMID;
import static com.example.elwis.ucarereadytohelp.R.layout.activity_second;
import static com.example.elwis.ucarereadytohelp.R.mipmap.utipedia;
import static com.example.elwis.ucarereadytohelp.R.string.Referenceid;


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
                HashMap postData = new HashMap();
                final String Drugname = etDrugname.getText().toString();
                final Post Referenceid = new Post();
               Referenceid.setReference("$resistance_ref", Referenceid);
                //String Referenceid = $resistance_ref;
                postData.put("txtDrugname", Drugname);

                PostResponseAsyncTask task1 = new PostResponseAsyncTask(SecondActivity.this, postData,
                        new AsyncResponse() {
                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);
                                if (s.contains("Drug found")) {
                                    //Toast.makeText(SecondActivity.this, "Drug Successfully found", Toast.LENGTH_LONG).show();
                                   // Intent intent = new Intent(SecondActivity.this, DisplayActivity.class);
                                    //Bundle bundle = new Bundle();

                                    //bundle.putString("Referenceid",Referenceid.getText().toString());
                                    Intent intent = new Intent(SecondActivity.this, DisplayActivity.class);
                                    intent.putExtra("Drugname", etDrugname.getText().toString());
                                    intent.putExtra("Referenceid", Referenceid);
// assign the bundle to the intent

                                   // i.putExtras(bundle);
// finally start the new activity
                                    startActivity(intent);



                                   // intent.putExtra("Drugname", etDrugname.getText().toString());
                                   // final Intent referenceid = intent.putExtra("Referenceid", Referenceid);
                                    //intent.putExtras(intent);
                                    //startActivity(intent);
                                } else {
                                    Intent intent = new Intent(SecondActivity.this, Display2Activity.class);
                                    intent.putExtra("Drugname", etDrugname.getText().toString());
                                    startActivity(intent);
                                }
                            }
                        });
                task1.execute("http://www.e-bioinformatics.net/db/utipedia/test/login2.php");
            }
        }







// @Override
   // public void onClick(View v) {
   //     HashMap postData = new HashMap();
    //    String Drugname = etDrugname.getText().toString();
        //String Referenceid = $resistance_ref;
    //    postData.put("txtDrugname", Drugname);
     //   PostResponseAsyncTask task1 = new PostResponseAsyncTask(SecondActivity.this, postData,
    //            new AsyncResponse() {
         //           @Override
         //           public void processFinish(String s) {

          //      });
       // task1.execute("");
   // }
//}*/

