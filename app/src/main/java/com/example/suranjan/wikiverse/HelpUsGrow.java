package com.example.suranjan.wikiverse;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import java.util.HashMap;
import java.util.Map;



public class HelpUsGrow extends AppCompatActivity {
    public static final String TAG = "aa";
    FirebaseFirestore db;
    EditText word;
    EditText def;
    Button addDefi;
    @Override
    public void onCreate(Bundle b)
    {
        super.onCreate(b);
        setContentView(R.layout.help_us_grow);
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestore.setFirestoreSettings(settings);
         db = FirebaseFirestore.getInstance();
         word = findViewById(R.id.word);
         def = findViewById(R.id.def);
    }

    public void addDef(View view)
    {
        String w = word.getText().toString();
        String defi= def.getText().toString();
        Map<String, Object> user = new HashMap<>();
        user.put("word", w);
        user.put("mean", defi);
        DocumentReference mydoc = db.document("users/kzwNFcy2VduKXrHd4Ygs");
// Add a new document with a generated ID
        /*db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });*/
        mydoc.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d("aa","Document has been saved");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("aa","Document has not been saved");
            }
        });
    }


    public void addDeff(View view) {
            FirebaseFirestore db = FirebaseFirestore.getInstance();
            DocumentReference mydoc = db.document("users/kzwNFcy2VduKXrHd4Ygs");
            mydoc.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    boolean flag3 = false;
                    if(documentSnapshot.exists())
                    {
                        TextView t1 = findViewById(R.id.searchfromDbs);
                        String hh= t1.getText().toString();
                        String word = documentSnapshot.getString("word");
                        try{
                            if(word.equalsIgnoreCase(hh))
                            {
                                String mean1 = documentSnapshot.getString("mean");
                                TextView t = findViewById(R.id.s1);
                                t.setText(mean1);
                                flag3 = true;
                            }
                            else
                            {
                                TextView t = findViewById(R.id.s1);
                                t.setText("No Results Found");
                            }
                        }catch (NullPointerException ex)
                        {
                            ex.printStackTrace();
                        }


                    }
                }
            });
        }
    }

