/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lambobot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/**
 *
 * @author Default7
 */
public class NetClient {

    public NetClient( ){
        
    } 
        
    public void getMarket() throws ParseException{
	  try {

		URL url = new URL("https://bittrex.com/api/v1.1/public/getmarkets");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                
                String line;
		StringBuffer output = new StringBuffer();
		System.out.println("Output from Server .... \n");
		while ((line = br.readLine()) != null) {
			output.append(line);
		}

                JSONObject object = (JSONObject)JSONValue.parseWithException(output.toString());

                JSONArray markets = (JSONArray)object.get("result");
                Iterator i = markets.iterator();
                
                List<String> coinName = new ArrayList<String>();
                
                while (i.hasNext()) {
                    JSONObject market = (JSONObject) i.next();
                    coinName.add(market.get("MarketName").toString());
                }
                Collections.sort(coinName);                
                
                coinName.forEach(name->System.out.println(name));

		conn.disconnect();

	  } catch (MalformedURLException e) {
	  } catch (IOException e) {
	  }
    }


}
