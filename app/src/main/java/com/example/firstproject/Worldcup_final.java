package com.example.firstproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Worldcup_final extends AppCompatActivity {
    ImageView iv1, iv2;
    TextView tv1, tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldcup);
        /*
         * 결승
         */
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        Intent intent = getIntent();
        ArrayList<Worldcup.Person> people = (ArrayList<Worldcup.Person>) intent.getSerializableExtra("people");
        Collections.shuffle(people);
        iv1.setImageResource(people.get(0).resource);
        tv1.setText(people.get(0).name);
        iv2.setImageResource(people.get(1).resource);
        tv2.setText(people.get(1).name);
        /*
         * ImageView 선택시 dialog 생성되며
         * 해당 연예인 사진과 이름 화면에 띄워짐.
         * dialog 의 닫기 버튼 누르면 초기 화면으로 돌아감.
         */
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialog = (View) View.inflate(Worldcup_final.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Worldcup_final.this);
                ImageView img = (ImageView) dialog.findViewById(R.id.dialogImg);
                img.setImageResource(people.get(0).resource);
                dlg.setTitle(people.get(0).name);
                dlg.setIcon(R.drawable.trophy);
                dlg.setView(dialog);
                dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*
                         * 닫기 선택시 초기화면으로 돌아감
                         */
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                dlg.show();
            }
        });
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialog = (View) View.inflate(Worldcup_final.this, R.layout.dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Worldcup_final.this);
                ImageView img = (ImageView) dialog.findViewById(R.id.dialogImg);
                img.setImageResource(people.get(1).resource);
                dlg.setTitle(people.get(1).name);
                dlg.setIcon(R.drawable.trophy);
                dlg.setView(dialog);
                dlg.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }
                });
                dlg.show();
            }
        });
    }
}
