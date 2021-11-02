package com.renfa.helper;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.renfa.exception.EmptyResultException;
import com.renfa.helper.JsonHelper;
import com.renfa.model.Option;

public class OptionHelper {

    public static String getOptionCode(String ticker, Date expiryDate, boolean isCall, float strikePrice){
        return String.format("%s%s%s%08d", ticker.toLowerCase(), new SimpleDateFormat("yyMMdd").format(expiryDate), isCall ? "C" : "P", (int)(strikePrice * 1000));
    }

    public static Option getOptionValue(String optionCode) {
        JSONObject json;
        Option opt = new Option();

        try {
            json = JsonHelper.readJsonFromUrl(String.format("https://query2.finance.yahoo.com/v7/finance/options/%s", optionCode));
           // System.out.println(String.format("https://query2.finance.yahoo.com/v7/finance/options/%s", optionCode));
           // System.out.println(json.toString());
            //json.get("optionChain").get("result").JsonArray();
            JSONArray result = json.getJSONObject("optionChain").getJSONArray("result");
            if(result.length() == 0){
                throw new EmptyResultException("No Option Data");
            }
            JSONObject marketData  = result.getJSONObject(0).getJSONObject("quote");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            opt.setTicker(marketData.getString("underlyingSymbol"));
            opt.setPrice(marketData.getFloat("regularMarketPrice"));
            opt.setStrikePrice(marketData.getFloat("strike"));
            opt.setOpenInterest(marketData.getInt("openInterest"));
            opt.setCall(marketData.getString("shortName").endsWith("call"));
            opt.setExpiryDate(new Date(marketData.getLong("expireDate") * 1000));
            
            //https://stackoverflow.com/questions/50785794/how-to-get-value-in-json-array-using-gson/50785893

        }catch (EmptyResultException ex){
            System.out.println("OptionHelper.getOptionValue: " + ex.getMessage());
        } catch (JSONException ex){
            System.out.println("OptionHelper.getOptionValue: Fail to process JSON");
        } catch (Exception ex){
            System.out.println("OptionHelper.getOptionValue: Fail to get data?");
        }
        return opt;
    }
}
