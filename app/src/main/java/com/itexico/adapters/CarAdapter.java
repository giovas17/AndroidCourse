package com.itexico.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itexico.androidcourse.R;
import com.itexico.models.Car;

import java.util.ArrayList;

/**
 * Created by darkgeat on 09/03/2017.
 */

public class CarAdapter extends ArrayAdapter<Car>{

    private ArrayList<Car> data;
    private Context context;

    public CarAdapter(@NonNull Context context, ArrayList<Car> cars) {
        super(context, R.layout.item_car,cars);
        data = cars;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View viewRow = LayoutInflater.from(context).inflate(R.layout.item_car,parent,false);

        Car car = data.get(position);

        ImageView imageItem = (ImageView)viewRow.findViewById(R.id.imageItem);
        imageItem.setImageResource(car.getImage());

        TextView title = (TextView)viewRow.findViewById(R.id.titleItem);
        title.setText(car.getTitle());

        TextView description = (TextView)viewRow.findViewById(R.id.descriptionItem);
        description.setText(car.getDescription());

        return viewRow;
    }

    @Override
    public int getCount() {
        return data.size();
    }
}
