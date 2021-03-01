package com.example.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView androidPhone, iOsPhone;
    RadioButton cardRadio, cashRadio;
    CheckBox withpresents, toaddress;
    Button submitBtn;

    String typePayment, delivarytext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);

        cardRadio = findViewById(R.id.cardRadio);
        cashRadio = findViewById(R.id.cashRadio);

        withpresents = findViewById(R.id.withpresents);
        toaddress = findViewById(R.id.toaddress);

        submitBtn = findViewById(R.id.submitBtn);

        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cardRadio.isChecked()){
                    typePayment = "to credit card";
                }else if(cashRadio.isChecked()){
                    typePayment = "to cash";
                }

                if(withpresents.isChecked()){
                    delivarytext = "to credit card";
                }

                if(toaddress.isChecked()){
                    delivarytext = "to cash";
                }

                String result = "Android: "+androidPhone.getText()+"\n"+
                                "iOs: "+iOsPhone.getText()+"\n"+
                                "Type of Payment: "+typePayment+"\n"+
                                "Delivary: "+delivarytext;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == androidPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }
        if(v == iOsPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.huaweiPhone:
                androidPhone.setText("Huawei");
                break;
            case R.id.xiaomiPhone:
                androidPhone.setText("Xiaomi");
                break;
            case R.id.oneplusPhone:
                androidPhone.setText("OnePlus");
                break;
            case R.id.oppoPhone:
                androidPhone.setText("Oppo");
                break;

            case R.id.iphone:
                iOsPhone.setText("iPhone");
                break;
            case R.id.macbook:
                iOsPhone.setText("MacBook");
                break;
            case R.id.applewatch:
                iOsPhone.setText("AppleWatch");
                break;
            case R.id.airpods:
                iOsPhone.setText("AirPods");
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Settings menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildi", Toast.LENGTH_LONG).show();
                break;

            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}