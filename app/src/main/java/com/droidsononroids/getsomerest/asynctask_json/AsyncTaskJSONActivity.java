package com.droidsononroids.getsomerest.asynctask_json;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.droidsononroids.getsomerest.R;
import com.droidsononroids.getsomerest.model.Name;
import com.droidsononroids.getsomerest.model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AsyncTaskJSONActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_json);
        new GetUserTask().execute();

    }

    class GetUserTask extends AsyncTask<Void, Integer, String>{

        private static final String TAG = "GetUserTask";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.e(TAG, "onPreExecute: Hello");
        }

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


                final JSONObject jsonObject = new JSONObject(rawResponse);
                final JSONArray results = jsonObject.getJSONArray("results");
                final JSONObject jsonUser = results.getJSONObject(0);
                final JSONObject jsonName = jsonUser.getJSONObject("name");

                final User user = new User();
                user.phone = jsonUser.getString("phone");

                final Name name = new Name();
                name.first = jsonName.getString("first");
                name.last = jsonName.getString("last");
                user.name = name;

                Log.d("USER JSON", user.toString());
                httpURLConnection.disconnect();

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return "PWR";
        }

        @Override
        protected void onPostExecute(final String s) {
            super.onPostExecute(s);
            Log.i(TAG, "onPostExecute: Bye!");
        }
    }
}
