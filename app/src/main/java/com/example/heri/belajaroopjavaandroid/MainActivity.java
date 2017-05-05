package com.example.heri.belajaroopjavaandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    int num = 0;

    @BindView(R.id.txt)
    TextView txt;
    @BindView(R.id.et)
    EditText editText;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.chbx)
    CheckBox ck1;
    @BindView(R.id.chbox)
    CheckBox ck2;
    @BindView(R.id.chboxe)
    CheckBox ck3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Klik Disini", Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Try", Toast.LENGTH_LONG).show();
            }
        });
        final ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(ck1);
        checkBoxes.add(ck2);
        checkBoxes.add(ck3);
        final int limit = 2;
        for (final CheckBox checkBox : checkBoxes) {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        int total = 0;
                        for (CheckBox cb : checkBoxes) {
                            if (cb.isChecked()) {
                                total++;
                            }
                        }
                        if (total > limit) {
                            checkBox.setChecked(false);
                        }
                    }
                }
            });
        }
    }
}
