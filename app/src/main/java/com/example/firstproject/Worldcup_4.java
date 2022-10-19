package com.example.firstproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Worldcup_4 extends AppCompatActivity {
    ImageView iv1, iv2;
    TextView tv1, tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldcup);
        /*
         * 4강
         */
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        Intent intent = getIntent();

        ArrayList<Worldcup.Person> people_4 = (ArrayList<Worldcup.Person>) intent.getSerializableExtra("people");
        ArrayList<Worldcup.Person> people_2 = new ArrayList<>();

        /*
         * 이하 WorldCup 파일과 동일
         */
        Collections.shuffle(people_4);
        iv1.setImageResource(people_4.get(0).resource);
        tv1.setText(people_4.get(0).name);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people_2.add(people_4.get(0));
                final Toast toast = Toast.makeText(getApplicationContext(), tv1.getText().toString() + " 선택", Toast.LENGTH_SHORT);
                toast.show();
                Thread t = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            toast.cancel();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
                people_4.remove(0);
                people_4.remove(0);
                if (people_4.size() == 0) {
                    Intent intent = new Intent(getApplicationContext(), Worldcup_final.class);
                    intent.putExtra("people", people_2);
                    startActivity(intent);
                    finish();
                    return;
                }
                iv1.setImageResource(people_4.get(0).resource);
                tv1.setText(people_4.get(0).name);
                iv2.setImageResource(people_4.get(1).resource);
                tv2.setText(people_4.get(1).name);
            }
        });
        iv2.setImageResource(people_4.get(1).resource);
        tv2.setText(people_4.get(1).name);
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people_2.add(people_4.get(1));
                final Toast toast = Toast.makeText(getApplicationContext(), tv1.getText().toString() + " 선택", Toast.LENGTH_SHORT);
                toast.show();
                Thread t = new Thread() {
                    public void run() {
                        try {
                            sleep(500);
                            toast.cancel();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                t.start();
                people_4.remove(0);
                people_4.remove(0);
                if (people_4.size() == 0) {
                    Intent intent = new Intent(getApplicationContext(), Worldcup_final.class);
                    intent.putExtra("people", people_2);
                    startActivity(intent);
                    finish();
                    return;
                }
                iv1.setImageResource(people_4.get(0).resource);
                tv1.setText(people_4.get(0).name);
                iv2.setImageResource(people_4.get(1).resource);
                tv2.setText(people_4.get(1).name);
            }
        });
    }
}
