package com.sicnu.wagesystems.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdinaryUser {

  private long id;
  private String name;
  private String username;
  private String password;
  private long cardId;
  private String gender;
  private long birthday;

}
