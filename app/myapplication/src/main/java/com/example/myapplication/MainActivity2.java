package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    private ListView listView;
    private PostAdapter postAdapter;
    private ModelDAO modelDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        postAdapter = new PostAdapter(getModele());
        listView = findViewById(R.id.listView1);
        listView.setAdapter(postAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random random = new Random();
                int rand_int = random.nextInt(2);
                if (rand_int == 0) {
                    postAdapter.updateList(getModele());
//                    postAdapter.updateList(lst1);
                } else {
                    postAdapter.updateList(getModele2());
                }
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Model m = postAdapter.getItem(position);
                Toast.makeText(MainActivity2.this, m.toString(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        JSONReader jsonReader = new JSONReader();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                jsonReader.read("https://jsonkeeper.com/b/T29K", new IResponse() {
                    @Override
                    public void onSuccess(List<Model> modele) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                Toast.makeText(MainActivity2.this, modele.toString(), Toast.LENGTH_SHORT).show();
                                postAdapter.updateList(modele);
                            }
                        });
                    }

                    @Override
                    public void onError(String mesaj) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity2.this, mesaj, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
        thread.start();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                modelDAO = Database.getInstance(MainActivity2.this).getDatabase().modelDAO();
                for (int i = 0; i < getModele().size(); i++) {
                    modelDAO.insertAll(getModele().get(i));
                }
//        modelDAO.insertAll(getModele().get(0), getModele().get(1));
                List<Model> lst1 = modelDAO.getModelsHigh(3);
                Log.v("lst1", lst1.toString());
            }
        });
        thread1.start();
    }

    private List<Model> getModele() {
        List<Model> lst = new ArrayList<>();
        lst.add(new Model(R.drawable.eddeddeddycactus, "Eddie Smith", "HaHaHA", R.drawable.a7023d2a049175534009f05c2248e8f3));
        lst.add(new Model(R.drawable._04_5040528_empty_profile_picture_png_transparent_png, "John Smith", "cute:)", R.drawable.e686fa6954ee9a1672e4dd0c3859cfdc));
        lst.add(new Model(R.drawable._22739_user_512x512, "Gus Walker", "lmao!", R.drawable.cat));
        return lst;
    }

    private List<Model> getModele2() {
        List<Model> lst = new ArrayList<>();
        lst.add(new Model(R.drawable._04_5040528_empty_profile_picture_png_transparent_png, "Mario White", "kappa", R.drawable.cat2));
        lst.add(new Model(R.drawable._04_5040528_empty_profile_picture_png_transparent_png, "Zack Bukowski", "cute:)", R.drawable.pika));
        lst.add(new Model(R.drawable._22739_user_512x512, "Maria Garcia", "xd!", R.drawable.ezf_tstxiaed3yg));
        return lst;
    }

}