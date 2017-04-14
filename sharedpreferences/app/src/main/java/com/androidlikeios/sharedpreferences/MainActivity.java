package com.androidlikeios.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFirstAccess;
    private EditText editTextName;
    private Button buttonSave;
    private TextView nameSaved;

    public static final String MY_PREFERENCES = "MyPrefs" ;
    public static final String MY_PREFS_NAME = "nameKey";
    public static final String MY_PREFS_FIRST_ACCESS = "firstAccessKey";

    //create var
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        setListeners();
        setTextNameSaved();

        if(isFirstAcces()) {
            textViewFirstAccess.setVisibility(View.VISIBLE);
            textViewFirstAccess.setText(getString(R.string.first_access));
        }
    }

    private void initialize() {
        textViewFirstAccess = (TextView) findViewById(R.id.text_view_first_access);
        editTextName = (EditText) findViewById(R.id.edit_text_name);
        buttonSave = (Button) findViewById(R.id.button_save);
        nameSaved = (TextView) findViewById(R.id.text_view_name_saved);

        //initialize
        sharedPreferences = getSharedPreferences(MY_PREFERENCES, MODE_PRIVATE);
    }

    public boolean isFirstAcces() {
        //get boolean
        if(sharedPreferences.getBoolean(MY_PREFS_FIRST_ACCESS, true)) {

            //update boolean value
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(MY_PREFS_FIRST_ACCESS, false);
            editor.apply();
            return true;
        }
        return false;
    }

    public String getNameSharedPreferences() {
        //get value string
        return sharedPreferences.getString(MY_PREFS_NAME, "");
    }

    public void setNameSharedPreferences() {
        //update string value
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MY_PREFS_NAME, editTextName.getText().toString());
        editor.apply();
    }

    public void setListeners() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNameSharedPreferences();
                setTextNameSaved();
            }
        });
    }

    public void setTextNameSaved() {
        nameSaved.setText(String.format(getResources().getString(R.string.name_saved), getNameSharedPreferences()));
    }
}