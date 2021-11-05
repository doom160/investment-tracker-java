package com.renfa.model;

import java.util.Date;

import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.renfa.helper.OptionHelper;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class StockHistory {

    @Id
    private String ticker;

    @Id
    private Date priceDate;

    private float price;

    private float high;

    private float low;

    private float close;

    private boolean call;

    @Getter(AccessLevel.NONE)
    private String id;
    public String getId() {
        return OptionHelper.getOptionCode(ticker, expiryDate, call, strikePrice);
    }
}
