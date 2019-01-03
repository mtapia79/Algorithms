package cl.ejercicios.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.*;
import com.google.gson.annotations.SerializedName;

public class RestService {

    public static void main(String[] args) {
        
        //RestService.openAndClosePrices("1-January-2000","22-February-2000", "Monday");
        RestService.openAndClosePrices("26-March-2001","15-August-2001", "Wednesday");
    }
    
    public static int getDayNumber(String dayWeek) {
        Map<String, Integer> ht = new HashMap<String, Integer>();
        ht.put("Monday", Calendar.getInstance().MONDAY);
        ht.put("Tuesday", Calendar.getInstance().TUESDAY);
        ht.put("Wednesday", Calendar.getInstance().WEDNESDAY);
        ht.put("Thursday", Calendar.getInstance().THURSDAY);
        ht.put("Friday", Calendar.getInstance().FRIDAY);
        ht.put("Saturday", Calendar.getInstance().SATURDAY);
        ht.put("Sunday", Calendar.getInstance().SUNDAY);
        
        return ht.get(dayWeek);
    }
    
    public static void openAndClosePrices(String firstDate, String lastDate, String weekDay) {
        String json = getJsonData("https://jsonmock.hackerrank.com/api/stocks");
        
        System.out.println("final:" + json.toString());
        
         
         final Gson gson = new Gson();
         final Date fechas = gson.fromJson(json.toString(), Date.class);

         
         java.util.Date ini = getParsedDate(firstDate);
         Calendar calIni  = Calendar.getInstance();
         calIni.setTime(ini);
         
         java.util.Date fin = getParsedDate(lastDate);
         Calendar calFin  = Calendar.getInstance();
         calFin.setTime(fin);
         
         for(DateList d : fechas.data)
         {
            String currentDateString = d.date;
            
            java.util.Date curr = getParsedDate(currentDateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime( curr);
            
            int day = cal.get(Calendar.DAY_OF_WEEK);
            
            if(day == getDayNumber(weekDay)) {
                
                if(curr.compareTo(ini) > 0) {
                    
                    if(curr.compareTo(fin) > 0) {
                        break;
                    }
                    System.out.println(currentDateString + " " + d.open + " " + d.close);
                }
               
            }
            
         }
      
    }
    
    
    

    public static java.util.Date getParsedDate(String currentDateString){
        SimpleDateFormat parser = new SimpleDateFormat("d-MMMM-yyyy");
        java.util.Date thedate = null;
        
        try {
               thedate = parser.parse(currentDateString);
           } catch (ParseException e1) {

               e1.printStackTrace();
           }
       
        return thedate;
    }
    
    public static String getJsonData(String _url) {
        
        StringBuffer response = new StringBuffer();
        
        try {

            URL url = new URL(_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            
            String output;

            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            
            conn.disconnect();


          } catch (MalformedURLException e) {

            e.printStackTrace();

          } catch (IOException e) {

            e.printStackTrace();

          }
        
       return response.toString();
        
    }
    
     class Date{
         private int page;
         private int per_page;
         private int total;
         private int total_pages;
         private  List<DateList> data;

     }
     class DateList {

        @SerializedName("date")
        private String date;

        @SerializedName("open")
        private float open;

        @SerializedName("close")
        private float close;

        @SerializedName("high")
        private float high;
        
        @SerializedName("low")
        private float low;
        
      }
    
}


