package com.renfa.helper;

import java.util.Date;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

import com.renfa.helper.JsonHelper;

public class OptionHelper {
    public static String getOptionCode(String ticker, Date expiryDate, boolean isCall, float strikePrice){
        return String.format("%s%s%s%07d", ticker.toLowerCase(), new SimpleDateFormat("ddMMyy").format(expiryDate), isCall ? "C" : "P", (int)(strikePrice * 1000));
    }

    public static float getOptionValue(String optionCode) {
        JSONObject json;
        float value = 0f;

        try {
            json = JsonHelper.readJsonFromUrl(String.format("https://query2.finance.yahoo.com/v7/finance/options/%s", optionCode));
            //json.get("optionChain").get("result").JsonArray();
            JSONObject marketData = json.getJSONObject("optionChain").getJSONArray("result").getJSONObject(0).getJSONObject("quote");
            value = (marketData.getFloat("bid") + marketData.getFloat("ask")) / 2f;

            //https://stackoverflow.com/questions/50785794/how-to-get-value-in-json-array-using-gson/50785893

        } catch (JSONException ex){
            System.out.println("OptionHelper.getOptionValue: Fail to process JSON");
        } catch (Exception ex){
            System.out.println("OptionHelper.getOptionValue: Fail to get data?");
        }
        return value;
    }
}
