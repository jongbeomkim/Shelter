package com.example.teamproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

public class ViewActivity extends AppCompatActivity {

    private int view = 10;

    private ImageView m_v_image;
    private TextView m_v_shelterName;
    private TextView m_v_provider;
    private TextView m_v_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        m_v_image = (ImageView)findViewById(R.id.v_image);
        m_v_shelterName = (TextView)findViewById(R.id.v_shelterName);
        m_v_provider = (TextView)findViewById(R.id.v_provider);
        m_v_location = (TextView)findViewById(R.id.v_location);
    }

    public void mOnClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.v_button_EDIT:
                intent = new Intent(this, EditActivity.class);

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.shelter);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("pic",byteArray);
                intent.putExtra("s_name",m_v_shelterName.getText().toString());
                intent.putExtra("p_name",m_v_provider.getText().toString());
                intent.putExtra("l_name",m_v_location.getText().toString());
                intent.putExtra("code",10);  //EditActivity에서 ViewActivity인 것을 구분하기 위한 코드
                startActivityForResult(intent, view);
                break;
        }
    }
}