package com.example.firstproject;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class list extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        /* 내장된 모든 연예인 사진을 GridView 로 보여줌*/
        GridView gv = (GridView) findViewById(R.id.gv);
        Grid adt = new Grid(this);
        gv.setAdapter(adt);
    }

    public class Grid extends BaseAdapter {
        Context context;

        public Grid(Context c) {
            context = c;
        }

        String[] nameList = {
                "차은우", "공유", "현빈", "정해인",
                "김선호", "김수현", "김우빈", "이종석",
                "이민호", "남주혁", "박보검", "박서준",
                "송중기", "송강", "원빈", "유아인",
                "한가인", "한효주", "한예슬", "아이린",
                "아이유", "제니", "전지현", "김태희",
                "이민정", "이나영", "임수정", "신민아",
                "송혜교", "손예진", "수지", "윤아"
        };

        Integer[] idList = {
                R.drawable.chaeunwoo, R.drawable.gongyoo, R.drawable.hyunbin, R.drawable.junghaein,
                R.drawable.kimseonho, R.drawable.kimsuhyun, R.drawable.kimwoobin, R.drawable.leejongsuk,
                R.drawable.leeminho, R.drawable.namjoohyuk, R.drawable.parkbogum, R.drawable.parkseojun,
                R.drawable.songjoongki, R.drawable.songkang, R.drawable.wonbin, R.drawable.yooahin,
                R.drawable.hangain, R.drawable.hanhyojoo, R.drawable.hanyeseul, R.drawable.irene,
                R.drawable.iu, R.drawable.jennie, R.drawable.junjihyun, R.drawable.kimtaehee,
                R.drawable.leeminjung, R.drawable.leenayoung, R.drawable.limsujung, R.drawable.shinmina,
                R.drawable.songhyekyo, R.drawable.sonyejin, R.drawable.suzi, R.drawable.yoona
        };

        @Override
        public int getCount() {
            return idList.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView img = new ImageView(context);
            img.setLayoutParams(new GridView.LayoutParams(200, 300));
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setPadding(5, 5, 5, 5);
            img.setImageResource(idList[position]);
            /*
             * 클릭시 이미지와 이름 dialog
             */
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialog = (View) View.inflate(list.this, R.layout.dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(list.this);
                    ImageView iv = (ImageView) dialog.findViewById(R.id.dialogImg);
                    iv.setImageResource(idList[position]);
                    dlg.setTitle(nameList[position]);
                    dlg.setView(dialog);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });
            return img;
        }
    }

}
