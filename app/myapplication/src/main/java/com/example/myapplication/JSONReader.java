package com.example.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JSONReader {
    private List<Integer> picList = new ArrayList<>();
    private List<Integer> postList = new ArrayList<>();

    public void read(String urlPath, IResponse response) {
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder result = new StringBuilder();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
//            Log.v("rezultat", result.toString());

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            List<Model> modele = parsare(result.toString());
            response.onSuccess(modele);

        } catch (MalformedURLException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            response.onError(e.getMessage());
        }
    }

    private List<Model> parsare(String jsonString) {
        List<Model> lst = new ArrayList<>();
        try {
            initializareLista1();
            initializareLista2();
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("persoane");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject currentObject = jsonArray.getJSONObject(i);
                Integer pic = currentObject.getInt("pic");
                String name = currentObject.getString("name");
                String desc = currentObject.getString("desc");
                Integer post = currentObject.getInt("post");
                Model model = new Model(picList.get(pic - 1), name, desc, postList.get(post - 1));
                lst.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return lst;
    }

    private void initializareLista1() {
        picList.add(R.drawable.eddeddeddycactus);
        picList.add(R.drawable._04_5040528_empty_profile_picture_png_transparent_png);
        picList.add(R.drawable._22739_user_512x512);
    }

    private void initializareLista2() {
        postList.add(R.drawable.a7023d2a049175534009f05c2248e8f3);
        postList.add(R.drawable.e686fa6954ee9a1672e4dd0c3859cfdc);
        postList.add(R.drawable.cat);
        postList.add(R.drawable.cat2);
        postList.add(R.drawable.pika);
        postList.add(R.drawable.ezf_tstxiaed3yg);
    }
}
