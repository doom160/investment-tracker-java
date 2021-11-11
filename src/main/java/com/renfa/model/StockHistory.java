package com.renfa.model;

import java.util.Date;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

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
}
