package com.example.simpleparadox.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    /**
     * returns number of cities in list
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * adds a city to the list
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
        return;
    }

    /**
     * returns true if city is in the list
     * @param city
     * @return
     */
    public boolean hasCity(City city){
        for (City cityList : cities){
            if (cityList.getCityName().equals(city.getCityName()) && cityList.getProvinceName().equals(city.getProvinceName())){
                return true;
            }
        }
        return false;
    }

    /**
     * removes city from list (or it's supposed to anyway)
     * @param city
     *      city to remove from list
     */
    public void deleteCity(City city){
        if (hasCity(city)){
            for (int i = 0; i < cities.size(); i++){
                if (cities.get(i).getCityName() == city.getCityName()
                        && cities.get(i).getProvinceName() == city.getProvinceName()){
                    cities.remove(i);
                    break;
                }
            }
        } else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * counts the number of cities in the list
     * @return
     *      returns the integer number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }

}
