package com.example.b10709046_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button btnBack, btnBackClean;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = (TextView) findViewById(R.id.textview_checked_num);
        /*Intent intent = getIntent();
        boolean[] isOptionChecked = intent.getBooleanArrayExtra("CHECKED_STATUS");*/
        int checkedNum = 0;
        for (boolean b : MyAdapter.getIsOptionChecked()) {
            if (b) checkedNum++;
        }
        String display = "您剛剛選了" + checkedNum + "個項目";
        resultTextView.setText(display);
        btnBack = (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMain = new Intent(ResultActivity.this, MainActivity.class);
                goMain.putExtra("CHECKED_STATUS", MyAdapter.getIsOptionChecked());
                startActivity(goMain);
            }
        });
        btnBackClean = (Button) findViewById(R.id.btn_back_clean);
        btnBackClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMain = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(goMain);
            }
        });
    }
}
