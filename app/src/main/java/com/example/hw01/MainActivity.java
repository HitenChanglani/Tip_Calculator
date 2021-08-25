package com.example.hw01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import static java.lang.Double.parseDouble;
import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    //Declaring variables
    SeekBar tipSeekBar;
    TextView viewProgress, tipAmount, totalAmount;
    Button exitButton;
    EditText editBillAmount;
    double valueTip, valueTotal;
    int customTipProgress, checkedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initializing variables
        tipSeekBar = findViewById(R.id.tipSeekBar);
        viewProgress = findViewById(R.id.viewProgress);
        exitButton = findViewById(R.id.exitButton);
        editBillAmount = findViewById(R.id.editBillAmount);
        tipAmount = findViewById(R.id.tipAmount);
        totalAmount = findViewById(R.id.totalAmount);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        customTipProgress = 20;
        tipSeekBar.setEnabled(false);



        //Listener function for every keystroke pressed by the user as input
        editBillAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkedId = radioGroup.getCheckedRadioButtonId();
                onChange(checkedId);
            }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        //Function to check the value of the radio button selected by the user and do calculations accordingly
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                onChange(checkedId);
            }
        });



        //Function to check the status of the custom tip selected by the user in the seek bar
        tipSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                viewProgress.setText(String.valueOf(progress));
                customTipProgress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(editBillAmount.getText().toString().isEmpty()){
                    tipAmount.setText("");
                    totalAmount.setText("");
                }
                else{
                    valueTip = parseDouble(editBillAmount.getText().toString()) * customTipProgress / 100;
                    tipAmount.setText(valueTip + "");
                    valueTotal = parseDouble(editBillAmount.getText().toString()) + valueTip;
                    totalAmount.setText(valueTotal + "");
                }
            }
        });



        //Button logic to exit the application when the user clicks it
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }



    //Function to check the radio button change and do necessary calculations as per change
    private void onChange(int checkedId) {
        if(checkedId == R.id.tenPercent){
            tipSeekBar.setEnabled(false);
            tipSeekBar.setProgress(20);
            viewProgress.setText(String.valueOf(20));
            if(editBillAmount.getText().toString().isEmpty()){
                tipAmount.setText("");
                totalAmount.setText("");
            }
            else{
                valueTip = parseDouble(editBillAmount.getText().toString()) * 10 / 100;
                tipAmount.setText(valueTip + "");
                valueTotal = parseDouble(editBillAmount.getText().toString()) + valueTip;
                totalAmount.setText(valueTotal + "");
            }
        }
        else if(checkedId == R.id.fifteenPercent){
            tipSeekBar.setEnabled(false);
            tipSeekBar.setProgress(20);
            viewProgress.setText(String.valueOf(20));
            if(editBillAmount.getText().toString().isEmpty()){
                tipAmount.setText("");
                totalAmount.setText("");
            }
            else{
                valueTip = parseDouble(editBillAmount.getText().toString()) * 15 / 100;
                tipAmount.setText(valueTip + "");
                valueTotal = parseDouble(editBillAmount.getText().toString()) + valueTip;
                totalAmount.setText(valueTotal + "");
            }
        }
        else if(checkedId == R.id.eighteenPercent){
            tipSeekBar.setEnabled(false);
            tipSeekBar.setProgress(20);
            viewProgress.setText(String.valueOf(20));
            if(editBillAmount.getText().toString().isEmpty()){
                tipAmount.setText("");
                totalAmount.setText("");
            }
            else{
                valueTip = parseDouble(editBillAmount.getText().toString()) * 18 / 100;
                tipAmount.setText(valueTip + "");
                valueTotal = parseDouble(editBillAmount.getText().toString()) + valueTip;
                totalAmount.setText(valueTotal + "");
            }
        }
        else if(checkedId == R.id.customTip){
            tipSeekBar.setEnabled(true);
            if(editBillAmount.getText().toString().isEmpty()){
                tipAmount.setText("");
                totalAmount.setText("");
            }
            else{
                valueTip = parseDouble(editBillAmount.getText().toString()) * customTipProgress / 100;
                tipAmount.setText(valueTip + "");
                valueTotal = parseDouble(editBillAmount.getText().toString()) + valueTip;
                totalAmount.setText(valueTotal + "");
            }
        }
    }
}