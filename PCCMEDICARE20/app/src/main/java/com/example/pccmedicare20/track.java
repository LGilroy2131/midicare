package com.example.pccmedicare20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class track extends AppCompatActivity {
    String dt = "2022/11/14";
    Button goback;
    ArrayList<String[]> meds = new ArrayList<String[]>();
    LocalDate d1;
    LocalDate d2;
    private static final String TAG = "calendar";

    private TextView thedate, medInfo;
    private Button buttonBack;
    private CalendarView mCalendarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        goback = (Button)findViewById(R.id.goback);
        Intent in = getIntent();
        meds = (ArrayList<String[]>) in.getSerializableExtra("xxx");// get curent list of meds

        thedate = (TextView) findViewById(R.id.textViewDate);
        medInfo = (TextView) findViewById(R.id.textViewMedInfo);
        mCalendarView = (CalendarView) findViewById(R.id.calendarView);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
        @Override
        public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
            month++;
            String date = year + "-";
                 if(month<10)
                     date=date+"0"+month + "-";
                 else
                     date=date+month+"-";
            if (dayOfMonth<10)
                     date = date +"0"+dayOfMonth;
            else
                date=date+dayOfMonth;
            //Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);

            thedate.setText(date);
//            if (medDay==dayOfMonth) { // condition to display medication for selected day.
//                medInfo.setText();

            d1= LocalDate.parse(date);
            //        //take
            String take="";
            for(String[] a: meds) {
            if(d1.isAfter(LocalDate.parse(a[4]))) {

                take=take+"take"+a[0]+"\n";
                     //print out

            }
//            if(a[2].equals("weekly")){
//                if (a[4].equals(dt)) {
//                    //print out
//                }
//
//            }

        }



        //refil
            String refil="";

        for(String[] a: meds) {

                if (LocalDate.parse(a[6]).equals(d1)) {
                    refil=refil+"Refil "+a[0]+"\n";

                    //print out
                }

            }
            medInfo.setText(refil+"\n"+take);





        }



















        });
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

