package com.droidsononroids.getsomerest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.droidsononroids.getsomerest.asynctask_gson.AsyncTaskGSONActivity;
import com.droidsononroids.getsomerest.asynctask_json.AsyncTaskJSONActivity;
import com.droidsononroids.getsomerest.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button_1 = (Button) findViewById(R.id.first_button);
        final Button button_2 = (Button) findViewById(R.id.second_button);
        final Button button_3 = (Button) findViewById(R.id.third_button);


        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(getBaseContext(), AsyncTaskJSONActivity.class));
            }
        });


        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(getBaseContext(), AsyncTaskGSONActivity.class));
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(getBaseContext(), RetrofitActivity.class));
            }
        });
    }
}

