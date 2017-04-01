package com.itexico.androidcourse;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.itexico.adapters.CarAdapter;
import com.itexico.models.Car;

import java.util.ArrayList;

/**
 * Created by darkgeat on 09/03/2017.
 */

public class SimpleCustomList extends AppCompatActivity {

    private ArrayList<Car> itemsToPopulate = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_custom_list);

        itemsToPopulate.add(new Car(R.drawable.carros1,"Lambo","Awesome car"));
        itemsToPopulate.add(new Car(R.drawable.carros2,"Mercedez","Awesome car"));
        itemsToPopulate.add(new Car(R.drawable.carros3,"Porshe","Awesome car"));
        itemsToPopulate.add(new Car(R.drawable.carros4,"BWM","Awesome car"));
        itemsToPopulate.add(new Car(R.drawable.carros5,"Ferrari","Awesome car"));

        CarAdapter adapter = new CarAdapter(this,itemsToPopulate);

        ListView list = (ListView)findViewById(R.id.listCustom);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SimpleCustomList.this,PostersList.class);
                startActivity(intent);
            }
        });
    }
}
