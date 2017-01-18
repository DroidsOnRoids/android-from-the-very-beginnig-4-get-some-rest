package com.droidsononroids.getsomerest.asynctask_gson;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.droidsononroids.getsomerest.R;
import com.droidsononroids.getsomerest.model.UserResponse;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskGSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_gson);
        new GetUserTask().execute();
    }

    class GetUserTask extends AsyncTask<Void, Integer, String> {


        @Override
        protected String doInBackground(final Void... voids) {
            try {
                final URL url = new URL("https://randomuser.me/api/");
                final HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                final InputStream inputStream = httpURLConnection.getInputStream();
                final InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                final String rawResponse = bufferedReader.readLine();
                Log.d("RAW JSON", rawResponse);

                final Gson gson = new Gson();
                final UserResponse userResponse = gson.fromJson(rawResponse, UserResponse.class);

                Log.d("USER GSON", userResponse.toString());
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "PWR";
        }

    }

}
