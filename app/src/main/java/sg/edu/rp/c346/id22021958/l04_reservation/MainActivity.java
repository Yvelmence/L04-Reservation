package sg.edu.rp.c346.id22021958.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnConfirm, btnReset;
    CheckBox checkbox;
    EditText etName, etPax, etPhoneNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        btnConfirm=findViewById(R.id.buttonEnter);
        btnReset=findViewById(R.id.buttonReset);
        checkbox=findViewById(R.id.checkBoxSmoke);
        etName=findViewById(R.id.editTextName);
        etPax=findViewById(R.id.editTextPax);
        etPhoneNumber=findViewById(R.id.editTextPhone);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 5, 1);

        btnConfirm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                int pax = Integer.parseInt(etPax.getText().toString());
                int phone = Integer.parseInt(etPhoneNumber.getText().toString());
                String smoke = "";
                if(checkbox.isChecked()){
                    smoke = "Smoking Area";
                }
                else{
                    smoke = "Non-Smoking Area";
                }

                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year= dp.getYear();

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                SimpleDateFormat simpleDateFormatTime = new SimpleDateFormat("HH:mm");
                CharSequence text = "Date: " + day+"/"+month+"/"+year + "Time: " +simpleDateFormatTime + smoke;

                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                etName.setText("");
                etPax.setText("");
                etPhoneNumber.setText("");
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
            }
        });

    }
}