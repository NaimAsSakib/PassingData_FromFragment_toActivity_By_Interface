package com.example.passingdataby_interface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SendDataInterface{
    TextView textView;
    Button button;

    BlankFragment blankFragment;

    boolean doubleBackpressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.tvAct);
        button=findViewById(R.id.btnMainAct);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opening Fragment
                blankFragment =new BlankFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,blankFragment).commit();

                button.setVisibility(View.GONE);//Vanishing button after opening the fragment
            }
        });

    }

    //Interface method
    @Override
    public void sendData(String data) {
        textView.setText(data);
    }

    @Override
    public void onBackPressed() {
        textView.setText(null);
        button.setVisibility(View.VISIBLE);
        if(doubleBackpressed==true){
            super.onBackPressed();
        }
    }
}