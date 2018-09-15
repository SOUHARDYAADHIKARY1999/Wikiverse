package com.example.suranjan.wikiverse;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    EditText query;
    TextView wordOftheDay;
    //TextView latestNews;
    TextView result1;
    ImageView image;
    String q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result1 = findViewById(R.id.result);
        image = findViewById(R.id.imageId);
        //wordOftheDay = findViewById(R.id.wordOfDay);
        //latestNews = findViewById(R.id.latestNews);
        query = findViewById(R.id.query);
    }

    public void searchQ(View view) {
        q = query.getText().toString();
        //getJason();
        MyAsyncTask myAsyncTask = new MyAsyncTask(result1);
        myAsyncTask.execute(q);
    }

    /*void getJason()
    {
        JSONParser parser = new JSONParser();
        try{
            JSONArray a = (JSONArray) parser.parse(new FileReader("app/dictionary.json"));

            for (int i = 0; i<a.length();i++)
            {
                JSONObject person = a.getJSONObject(i);
                //JSONObject person = (JSONObject) o;
                String word = person.getString("word");
                if(word == q)
                {
                    String mean = person.getString("mean");
                    result1.setText(mean);
                    break;
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

//        String jsonQ = "[{\"word\":\"VexAG\",\"mean\":\"Venus Exploration Analysis Group\"},{\"word\":\"volatiles\",\"mean\":\"Readily vapourizable at a relatively low temperature.\"},{\"word\":\"volcanism\",\"mean\":\"Volcanic action or activity\"}]";
//        Log.d("aa",jsonQ);
    }*/
    public void openBrowser(View view){

        //Get url from tag
        String url = (String)image.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void news1(View view) {
        //Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    /*public void news2(View view) {
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        //pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }

    public void news3(View view) {
    }*/
}
