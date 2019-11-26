package com.temp.jsonparseexample.model;

import android.content.Context;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class ParseJSON {
    public static String parse(Context context) {
        StringBuilder sb;
        sb = new StringBuilder();
        String json = null;
        try {
            InputStream is = context.getAssets().open("map_api.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("results");
            ArrayList<MapModel> mapModels = new ArrayList<>();
            MapModel mapModel = null;
            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                String name = jo_inside.getString("name");
                String vicinity = jo_inside.getString("vicinity");
                String rating = jo_inside.getString("rating");
                mapModel = new MapModel();
                mapModel.setName(name);
                mapModel.setRating(rating);
                mapModel.setVicinity(vicinity);
                mapModels.add(mapModel);
            }
            for (MapModel m : mapModels) {
                System.out.println(m.getName() + m.getVicinity() + m.getRating());
                sb.append("Name:");
                sb.append(m.getName());
                sb.append("\n");
                sb.append("Address:");
                sb.append(m.getVicinity());
                sb.append("\n");
                sb.append("Rating:");
                sb.append(m.getRating());
                sb.append("\n");
                sb.append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}//END OF CLASS
