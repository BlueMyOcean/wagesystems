package com.sicnu.wagesystems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdinaryBill {

  private long id;
  private Timestamp time;
  private String username;
  private long wage;
  private long cardId;

}
