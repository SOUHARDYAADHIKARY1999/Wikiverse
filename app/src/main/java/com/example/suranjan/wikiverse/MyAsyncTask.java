package com.example.suranjan.wikiverse;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import com.example.suranjan.wikiverse.NetworkUtil;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyAsyncTask extends AsyncTask<String,Void,String > {

    //TextView wname ;
    TextView def;
    public MyAsyncTask(TextView definition){
        //wname = title1;
        def = definition;
    }
//    @Override
//    protected String doInBackground(Void... voids) {
//        Random r =new Random();
//        int rand = r.nextInt(11);
//        int s = rand*200;
//        try {
//            Thread.sleep(s);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "Awake at last after sleeping for"+s+"miliseconds";
//    }

    @Override
    protected String doInBackground(String... s) {
        Log.d("aa",""+s[0]);
        //NetworkUtil n = new NetworkUtil();
        return NetworkUtil.getBookInfo(s[0]);
    }

    @Override
    protected  void onPostExecute(String s){

        super.onPostExecute(s);
//        try {
//            JSONObject jsonObject = new JSONObject(s);
//            JSONArray itemsArray = jsonObject.getJSONArray("weather");
//            for (int i= 0; i< itemsArray.length(); i++){
//                JSONObject wea = itemsArray.getJSONObject(i);
//                //String weaName = null;
//                String weaDetails = null;
//                //String price = null;
//                //JSONObject volumeInfo = book.getJSONObject("volumeInfo");
//                try{
//                    //weaName = wea.getString("main");
//
//                    weaDetails = wea.getString("main");
//                    Log.d("aa",weaDetails);
//                }
//                catch (Exception e) {
//                    e.printStackTrace();
//                }
//                //int len = auth.length()-2;
//                //Log.d("ab",price);
//                if(weaDetails !=null) {
//                    def.setText(weaDetails);
//                    //wname.setText(weaName);
//                    return;
//                }
//            }
//            //wname.setText("No Result Found");
//            def.setText("No Result Found");
//        }catch (Exception e){
//            //wname.setText("No Result Found");
//            def.setText("No Result Found");
//            e.printStackTrace();
//        }
        def.setText(s);


    }
}
