package com.example.elwis.ucarereadytohelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Comment;

public class DisplayActivity extends AppCompatActivity {

  //  private TextView Referenceid;

    @Override
protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_display);

       TextView nameView=(TextView)findViewById(R.id.result);
        TextView pmidTextView = (TextView) findViewById(R.id.PMID);
     nameView.setText(getIntent().getExtras().getString("Drugname"));


        Intent intent = getIntent();
        TextView Referenceid=(TextView)findViewById(R.id.PMID);
        Post myComment = (Post )intent.getParcelableExtra("Referenceid");
        String pmid = intent.getExtras().getString("pmid");
        pmidTextView.setText(pmid);
       // Referenceid.setText(getIntent().getExtras().getString("Referenceid"));
        //nameView.setText("Referenceid");

       // Bundle bundle= getIntent().getExtras();
        //TextView Referenceid = (TextView) findViewById(R.id.PMID);
        //Referenceid.setText(bundle.getCharSequence("Referenceid"));
       // String Referenceid = bundle.getString("Referenceid");

        //Create the text view
      //  TextView textView = new TextView(this);
        //textView.setTextSize(40);
      //  textView.setText(Referenceid);

        //set the text view as the activity layout
       // setContentView(textView);







//get the values by their keys
        //String Drugname =bundle.getString("Drugname");
        //TextView Referenceid=(TextView)findViewById(R.id.PMID);
       // Referenceid.setText(getIntent().getExtras().toString());
       //String Referenceid =bundle.toString();
// do whatever you like to the data



        //TextView PMID=(TextView)findViewById(R.id.PMID);
        //PMID.setText(getIntent().getExtras().getString("Referenceid"));
        //PMID.setText("Referenceid");
  //Linkify.addLinks(PMID, Linkify.WEB_URLS);
}


}

