package com.temp.jsonparseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.temp.jsonparseexample.model.ParseJSON;
import com.temp.jsonparseexample.model.ParseXML;

public class MainActivity extends AppCompatActivity {

    TextView textXML ,textJSON;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textXML = findViewById( R.id.textXML) ;
        textJSON = findViewById( R.id.textJSON) ;

        String text1 = ParseXML.parse( this );
        textXML.setText(text1);

        String text2 = ParseJSON.parse( this );
        textJSON.setText(text2);
    }
}


