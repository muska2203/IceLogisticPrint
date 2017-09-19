
import com.google.gson.Gson;
import java.util.Map;

import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Helper {
    public static String getCar(String number, String json) {
        Gson gson = new Gson();
        Map<String,String> map = gson.fromJson(json, Map.class);
        return map.get(number);
    }
}
