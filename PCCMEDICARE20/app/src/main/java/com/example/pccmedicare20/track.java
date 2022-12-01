package com.example.pccmedicare20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class track extends AppCompatActivity {
    String dt = "2022/11/14";
    Button goback;
    ArrayList<String[]> meds = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        goback = (Button)findViewById(R.id.goback);
        Intent in = getIntent();
        meds = (ArrayList<String[]>) in.getSerializableExtra("xxx");// get curent list of meds


        //take
        for(String[] a: meds) {
            if(a[2].equals("daily")) {
                 if (a[4].equals(dt)) {
                //print out
                 }
            }
            if(a[2].equals("weekly")){
                if (a[4].equals(dt)) {
                    //print out
                }

            }

        }



        //refil
        for(String[] a: meds) {

                if (a[4].equals(dt)) {
                    //print out
                }

            }














        goback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                home();
            }
        });

    }
    private void home(){
        Intent intent = new Intent(this,show.class);
        Bundle bundle = new Bundle();

        intent.putExtra("xxx", meds);
        intent.putExtras(bundle);

        startActivity(intent);
    }


}

