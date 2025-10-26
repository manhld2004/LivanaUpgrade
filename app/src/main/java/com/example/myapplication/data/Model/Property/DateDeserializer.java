package com.example.myapplication.data.Model.Property;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeserializer implements JsonDeserializer<Date> {
    private final SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        try {
            if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
                return isoFormat.parse(json.getAsString());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
