package com.example.elwis.ucarereadytohelp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class DisplayActivity extends AppCompatActivity  {

    @Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_display);

       TextView nameView=(TextView)findViewById(R.id.result);
        TextView pmidTextView = (TextView) findViewById(R.id.PMID);
        nameView.setText(getIntent().getExtras().getString("Drugname"));


        Intent intent = getIntent();
        String pmid = intent.getExtras().getString("pmid");
        pmidTextView.setClickable(true);
        pmidTextView.setMovementMethod(LinkMovementMethod.getInstance());
       // String refer = "<a href='https://www.ncbi.nlm.nih.gov/pubmed/pmid'>pmid</a>";
        pmidTextView.setText(Html.fromHtml(pmid));
        //Linkify.addLinks(PMID, Linkify.WEB_URLS);
}




}

