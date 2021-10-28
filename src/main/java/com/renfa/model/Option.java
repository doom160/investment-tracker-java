package com.renfa.model;

import java.util.Date;

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
public class Option {

    private String ticker;

    private float price;

    private int openInterest;

    private float strikePrice;

    private Date expiryDate;

    private boolean call;

    @Getter(AccessLevel.NONE)
    private String id;
    public String getId() {
        return OptionHelper.getOptionCode(ticker, expiryDate, call, strikePrice);
    }
}
