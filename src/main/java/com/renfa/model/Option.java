package com.renfa.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;

import lombok.AccessLevel;
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
@DiscriminatorValue("option")
public class Option extends Equity {

    private float strikePrice;

    private Date expiryDate;

    private boolean call;

    private String optionContractId;

}
