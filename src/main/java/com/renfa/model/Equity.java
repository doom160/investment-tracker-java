package com.renfa.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.DiscriminatorType;

@Entity(name="equity")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="equity_type", 
  discriminatorType = DiscriminatorType.STRING)
public class Equity {
    @Id
    private long equityId;

    private String ticker;

    private float qty;

    private float unitCost;
}
