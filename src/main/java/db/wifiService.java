package db;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class wifiService {
    public wifiData findWifi(String lat, String lnt){
        wifiData data = new wifiData();
        data.setX(lat);
        System.out.println(data.getX());
        return data;
    }

    public void findWifi2(String lat, String lnt) {
        List<wifiData> wifiList = new ArrayList<wifiData>();
        JSONParser parser = new JSONParser();

        try{
            FileReader reader = new FileReader("src/main/webapp/json/seoul-public-wifi.json");
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray data = (JSONArray) jsonObject.get("DATA");

            wifiData wifi = new wifiData();
            for (int i = 0; i < data.size(); i++) {
                JSONObject element = (JSONObject) data.get(i);
                //Double latNum = Double.parseDouble((String) element.get("lat"));
                //System.out.println(latNum);
                /*if((Math.round(latNum * 100)/ 100) == (Math.round(Double.parseDouble(lat) * 100)/ 100)){
                    System.out.println((String) element.get("lnt"));
                    wifi.setX((String) element.get("lnt"));
                }*/
                //wifiList.add(wifi);
            }
        }catch (IOException | ParseException e){
            e.printStackTrace();
        }

    }

}
