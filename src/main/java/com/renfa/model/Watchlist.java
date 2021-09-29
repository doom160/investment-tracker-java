package com.renfa.model;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watchlist")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Watchlist {

  @Id
  @Column(name = "ticker",  length = 10)
  private String ticker;

  @Column(name = "full_name", length = 40)
  private String fullName;
  
  @Column(name = "date_added", columnDefinition = "DATE")
  private LocalDate dateAdded;

  @Column(name = "last_updated", columnDefinition = "DATE")
  private LocalDate lastUpdated;

}
