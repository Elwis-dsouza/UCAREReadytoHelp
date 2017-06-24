package com.example.elwis.ucarereadytohelp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.elwis.ucarereadytohelp.R.id.PMID;

@SuppressWarnings("deprecation")
public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView nameView=(TextView)findViewById(R.id.result);
        final TextView pmidTextView = (TextView) findViewById(R.id.PMID);
        nameView.setText(getIntent().getExtras().getString("Drugname"));

        Intent intent = getIntent();
        String pmid = intent.getExtras().getString("pmid");
        pmidTextView.setClickable(true);
        pmidTextView.setMovementMethod(LinkMovementMethod.getInstance());
        pmidTextView.setText(Html.fromHtml(pmid));
        Linkify.addLinks(pmidTextView, Linkify.WEB_URLS);

        // nameView.setMovementMethod(LinkMovementMethod.getInstance());
        //nameView.setText(Html.fromHtml(pmid));
        //Linkify.addLinks((Spannable) nameView, Linkify.WEB_URLS);

    }

}
