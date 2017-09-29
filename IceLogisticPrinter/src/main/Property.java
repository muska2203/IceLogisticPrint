/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

    private String url = null;
    private float xShift = 0;
    private float yShift = 0;
    private Map<String, String> carMap = new HashMap<>();

    public Property(String urlProperties) {
        Properties properties = new Properties();
        String json = null;
        try {
            this.url = urlProperties;
            FileInputStream fis = new FileInputStream(this.url);
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
    
    public boolean renameCar(String number, String newName) {
        this.carMap.remove(number);
        this.carMap.put(number, newName);
        return true;
    }
    
    public boolean addCar(String number, String newName) {
        try {
            this.carMap.put(number, newName);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
    
    public boolean removeCar(String number) {
        try {
            this.carMap.remove(number);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public boolean saveProperties() {
        try {
            FileOutputStream fos = new FileOutputStream(this.url);
            Properties p = new Properties();
            p.put("xShift", ""+this.xShift);
            p.put("yShift", ""+this.yShift);
            p.put("cars",new Gson().toJson(this.carMap));
            p.store(fos, "");
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
