/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 *
 * @author admin
 */
public class Property {

    private float xShift = 0;
    private float yShift = 0;
    private Map<String, String> carMap = new HashMap<>();

    public Property(String urlProperties) {
        Properties properties = new Properties();
        String json = null;
        try {
            FileInputStream fis = new FileInputStream(urlProperties);
            properties.load(fis);
            fis.close();
            this.xShift = Float.valueOf(properties.getProperty("xShift"));
            this.yShift = Float.valueOf(properties.getProperty("yShift"));
            json = properties.getProperty("cars");
        } catch (IOException e) {
            System.err.println("Файл не существует");
        }
        if (json != null) {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, String>>() {
            }.getType();
            this.carMap = gson.fromJson(json, type);
        }
    }

    public float getxShift() {
        return xShift;
    }

    public float getyShift() {
        return yShift;
    }

    public Map<String, String> getCarMap() {
        return carMap;
    }

}
