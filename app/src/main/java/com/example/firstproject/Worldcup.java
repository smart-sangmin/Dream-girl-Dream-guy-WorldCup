package com.example.firstproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Worldcup extends AppCompatActivity {
    ImageView iv1, iv2;
    TextView tv1, tv2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.worldcup);

        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        /* 남자 연예인  */
        String[] namesMan = {
                "차은우", "공유", "현빈", "정해인",
                "김선호", "김수현", "김우빈", "이종석",
                "이민호", "남주혁", "박보검", "박서준",
                "송중기", "송강", "원빈", "유아인"
        };
        Integer[] resourcesMan = {
                R.drawable.chaeunwoo, R.drawable.gongyoo, R.drawable.hyunbin, R.drawable.junghaein,
                R.drawable.kimseonho, R.drawable.kimsuhyun, R.drawable.kimwoobin, R.drawable.leejongsuk,
                R.drawable.leeminho, R.drawable.namjoohyuk, R.drawable.parkbogum, R.drawable.parkseojun,
                R.drawable.songjoongki, R.drawable.songkang, R.drawable.wonbin, R.drawable.yooahin
        };
        /* 여자 연예인 */
        String[] namesWoman = {
                "한가인", "한효주", "한예슬", "아이린",
                "아이유", "제니", "전지현", "김태희",
                "이민정", "이나영", "임수정", "신민아",
                "송혜교", "손예진", "수지", "윤아"
        };
        Integer[] resourcesWoman = {
                R.drawable.hangain, R.drawable.hanhyojoo, R.drawable.hanyeseul, R.drawable.irene,
                R.drawable.iu, R.drawable.jennie, R.drawable.junjihyun, R.drawable.kimtaehee,
                R.drawable.leeminjung, R.drawable.leenayoung, R.drawable.limsujung, R.drawable.shinmina,
                R.drawable.songhyekyo, R.drawable.sonyejin, R.drawable.suzi, R.drawable.yoona
        };
        ArrayList<Person> people = new ArrayList<>();// 16강에서 쓸 변수
        ArrayList<Person> people_8 = new ArrayList<>();// 8강으로 보낼 변수
        /*이전에 눌렀던 정보를 받음(남자 1, 여자 2)*/
        Intent intent = getIntent();
        int gender = intent.getIntExtra("gender", -1);
        /* 남자인지 여자인지 체크 후 대입 */
        if (gender == 1) {
            for (int i = 0; i < 16; i++) {
                people.add(new Person(resourcesMan[i], namesMan[i]));
            }
        } else if (gender == 2) {
            for (int i = 0; i < 16; i++) {
                people.add(new Person(resourcesWoman[i], namesWoman[i]));
            }
        }
        Collections.shuffle(people); // 순서 섞어줌

        /* 첫번째 텍스트뷰와 이미지뷰 설정 */
        iv1.setImageResource(people.get(0).resource);
        tv1.setText(people.get(0).name);
        /* 두번째 텍스트뷰와 이미지뷰 설정 */
        iv2.setImageResource(people.get(1).resource);
        tv2.setText(people.get(1).name);
        /*
         * iv1 클릭시
         * 현재 보여지는 Person 두 개 people 리스트에서 삭제
         * 선택된 Person 변수 people_8에 추가
         */
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people_8.add(people.get(0));
                final Toast toast = Toast.makeText(getApplicationContext(), tv1.getText().toString() + " 선택", Toast.LENGTH_SHORT);
                toast.show();
                /* 토스트 지속시간 조절 */
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
                people.remove(0);
                people.remove(0);
                if (people.size() == 0) {
                    Intent intent = new Intent(getApplicationContext(), Worldcup_8.class);
                    intent.putExtra("people", people_8);
                    startActivity(intent);
                    finish();
                    return;
                }
                iv1.setImageResource(people.get(0).resource);
                tv1.setText(people.get(0).name);
                iv2.setImageResource(people.get(1).resource);
                tv2.setText(people.get(1).name);
            }
        });

        /*
         * iv2 클릭시
         * 현재 보여지는 Person 두 개 people 리스트에서 삭제
         * 선택된 Person 변수 people_8에 추가
         */
        iv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                people_8.add(people.get(1));
                final Toast toast = Toast.makeText(getApplicationContext(), tv1.getText().toString() + " 선택", Toast.LENGTH_SHORT);
                toast.show();
                /* 토스트 지속시간 조절 */
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
                people.remove(0);
                people.remove(0);
                if (people.size() == 0) {
                    Intent intent = new Intent(getApplicationContext(), Worldcup_8.class);
                    intent.putExtra("people", people_8);
                    startActivity(intent);
                    finish();
                    return;
                }
                iv1.setImageResource(people.get(0).resource);
                tv1.setText(people.get(0).name);
                iv2.setImageResource(people.get(1).resource);
                tv2.setText(people.get(1).name);
            }
        });
    }

    /* 사진 정보 및 이름 정보 */
    public static class Person implements Serializable {
        int resource;
        String name;

        Person(int r, String n) {
            this.resource = r;
            this.name = n;
        }
    }
}