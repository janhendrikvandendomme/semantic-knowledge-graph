package com.careerbuilder.search.relevancy.ResponseWriter;

import com.careerbuilder.search.relevancy.Models.ResponseValue;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ResponseValueSerializer implements JsonSerializer<ResponseValue> {

    public JsonElement serialize(ResponseValue src, Type type, JsonSerializationContext context)
    {
        JsonObject resp = new JsonObject();
        if(src.normalizedValue == null) {
            resp.addProperty("value", src.value);
        }
        else {
            src.normalizedValue.forEach((elem) -> resp.addProperty(elem.getKey(), elem.getValue()));
        }
        resp.addProperty("relatedness", src.relatedness);
        resp.addProperty("popularity", src.popularity);
        resp.addProperty("foreground_popularity", src.foreground_popularity);
        resp.addProperty("background_popularity", src.background_popularity);
        resp.add("compare", context.serialize(src.compare));
        return resp;
    }


}
