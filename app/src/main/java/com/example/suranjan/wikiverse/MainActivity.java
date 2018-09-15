package com.example.suranjan.wikiverse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
    TextView latestNews;
    TextView result1;
    String q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result1 = findViewById(R.id.result);
        wordOftheDay = findViewById(R.id.wordOfDay);
        latestNews = findViewById(R.id.latestNews);
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
}
