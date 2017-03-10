package com.itexico.androidcourse;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by darkgeat on 09/03/2017.
 */

public class SimpleListActivity extends AppCompatActivity {

    private String[] items = new String[]{
        "item1","item2","item3","item4","item5","item6","item7","item8","item9","item10",
            "item11","item12","item13","item14","item15","item16","item17","item18","item19","item20"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);

        ListView lista = (ListView)findViewById(R.id.listSimple);
        lista.setAdapter(adapter);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListActivity.this,items[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
