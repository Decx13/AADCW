package com.example.lk.ijse.gdse63.travelcw.utill;

import com.example.lk.ijse.gdse63.travelcw.dto.PricesDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;

public class StringToPricesListConverter implements Converter<String, ArrayList<PricesDTO>> {

    @Override
    public ArrayList<PricesDTO> convert(String source) {
        return new Gson().fromJson(source, new TypeToken<ArrayList<PricesDTO>>() {
        });
    }

}