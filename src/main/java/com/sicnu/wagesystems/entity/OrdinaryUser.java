package com.sicnu.wagesystems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdinaryUser {

  private long id;
  private String name;
  private String username;
  private String password;
  private String cardId;
  private int gender;
  private Date birthday;
  private String address;
  private long idCardNum;
  private String native_Place;
  private String folk;
  private String education;
  private String major;
  private long zipCode;
  private long phoneNum;
  private Double total;


}
