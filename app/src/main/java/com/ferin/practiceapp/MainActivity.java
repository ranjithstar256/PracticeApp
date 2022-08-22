package com.ferin.practiceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Buttons and Views
    EditText enterTextEditVar;
    Button okButtonVar;
    TextView textDisplayViewVar;

    EditText textIntentView;
    Button intentButtonVar;

    Button alertButtonVar;

    Button customDiaButtonVar;

    TextView textView;

    Button datePickerButtonVar;
    TextView dateDisplayViewVar;

    Button timePickerButtonVar;
    TextView timeDisplayViewVar;

    Button webViewButtonVar;

    Button musicButtonVar;

    VideoView videoViewMp4Var;
    Button videoButtonWebMp4Var;


    // Classes
    AlertDialog.Builder alertDialog;
    Dialog customDialog;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    MediaPlayer mediaPlayer;

    // String
    String enterTextString,enterIntentString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterTextEditVar = findViewById(R.id.enterTextEdit);
        okButtonVar = findViewById(R.id.enterTextDisButton);
        textDisplayViewVar = findViewById(R.id.enterTextDisplayView);

        textIntentView = findViewById(R.id.enterTextForIntent);
        intentButtonVar = findViewById(R.id.intentButton);

        alertButtonVar = findViewById(R.id.alertDialogButton);

        customDiaButtonVar = findViewById(R.id.customDialogButton);

        textView = findViewById(R.id.textView2);

        datePickerButtonVar = findViewById(R.id.dataPickerButton);
        dateDisplayViewVar = findViewById(R.id.datePickerText);

        timePickerButtonVar = findViewById(R.id.timePickerButton);
        timeDisplayViewVar = findViewById(R.id.timePickerText);

        webViewButtonVar = findViewById(R.id.webViewButton);

        musicButtonVar = findViewById(R.id.musicButton);

        videoViewMp4Var = findViewById(R.id.videoViewWebMp4);
        videoButtonWebMp4Var = findViewById(R.id.videoViewWebMp4Button);


        // Edit Text to display in TextView
        okButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterTextString = enterTextEditVar.getText().toString();
                textDisplayViewVar.setText(enterTextString);
            }
        });


        // Navigate to next activity, also data transfer between activities
        intentButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterIntentString = textIntentView.getText().toString();
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("IntentText", enterIntentString);
                startActivity(intent);
            }
        });


        // Alert Dialog Box
        alertButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Alert Dialog Box")
                        .setMessage("This is a Alert Dialog Box")
                        .setIcon(R.drawable.ic_launcher_background)
                        .setPositiveButton("No",null)
                        .setNegativeButton("Yes",null)
                        .setNeutralButton("Back",null)
                        .show();
            }
        });


        // Custom Dialog Box
        customDiaButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog = new Dialog(MainActivity.this);
                customDialog.setContentView(R.layout.custom_dialog);

                // USE THIS CODE IF YOU WANT THE BUTTON IN CUSTOM DIALOG TO WORK
//                EditText enterText = customDialog.findViewById(R.id.cusDiaLayoutEntText);
//                TextView textView = customDialog.findViewById(R.id.cusDiaLayoutTextView);
//                customDialog.findViewById(R.id.cusDiaLayoutButton).setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        String data = enterText.getText().toString();
//                        textView.setText(data);
//                    }
//                });
                // TILL HERE (ABOVE LINE)

                customDialog.show();
            }
        });


        // DatePicker Dialog
        datePickerButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // This is used if we want to show the current date in the picker
                Calendar c = Calendar.getInstance();
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                int mMonth = c.get(Calendar.MONTH);
                int mYear = c.get(Calendar.YEAR); // add these variables below

                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        dateDisplayViewVar.setText(i2+"/"+(i1+1)+"/"+i);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });


        // TimePicker Dialog
        timePickerButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // This is used if we want to show the current time in the picker
                Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR);
                int mMin = c.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        timeDisplayViewVar.setText(i+":"+i1);
                    }
                }, mHour, mMin, true);
                timePickerDialog.show();
            }
        });



        webViewButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent webViewIntent = new Intent(MainActivity.this,WebViewActivity.class);
                webViewIntent.putExtra("URL","https://www.google.com");
                startActivity(webViewIntent);
            }
        });



        // Music player
        musicButtonVar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.sorryaudiofile);
                mediaPlayer.start();
            }
        });


        // Plays video from Web - Mp4 format
        videoButtonWebMp4Var.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri video = Uri.parse("https://www.ebookfrenzy.com/android_book/movie.mp4");
                videoViewMp4Var.setVideoURI(video);
                videoViewMp4Var.start();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void About(MenuItem item) {
        Toast.makeText(MainActivity.this, "This is a practice app and an easy reference app", Toast.LENGTH_SHORT).show();
    }


    public void TextViewMethod(View view) {
        String toast = textView.getText().toString();
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }
}