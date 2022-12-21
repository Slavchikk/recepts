package com.example.recepts;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private AdapterRecipe pAdapter;


    private List<Recipe> listRecipe = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView ivProd = findViewById(R.id.lvData);
        pAdapter = new AdapterRecipe(MainActivity.this, listRecipe);
        ivProd.setAdapter(pAdapter);

        new GetProducts().execute();
    }


    private class GetProducts extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("https://ngknn.ru:5001/NGKNN/КарзиновВА/api/Recipes");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                StringBuilder result = new StringBuilder();
                String line = "";

                while((line=reader.readLine())!= null){
                    result.append(line);
                }
                return  result.toString();
            } catch (Exception e) {
                return null;
            }
        }
        @Override
        protected  void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONArray tempArray = new JSONArray(s);
                for(int i =0; i < tempArray.length();i++)
                {

                    JSONObject prodJson =  tempArray.getJSONObject(i);
                    Recipe tempPRoduct = new Recipe(
                            prodJson.getInt("idRecipe"),
                            prodJson.getString("fullRecipe"),
                            prodJson.getString("nameRecipe"),
                            prodJson.getString("image"),
                            prodJson.getString("calory"),
                            prodJson.getString("timeGot")


                    );
                    listRecipe.add(tempPRoduct);
                    pAdapter.notifyDataSetInvalidated();
                }
            } catch (Exception ignored){

            }
        }
    }
}