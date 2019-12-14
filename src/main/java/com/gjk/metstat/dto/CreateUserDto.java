package com.gjk.metstat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserDto {

  @NotNull
  private String username;

  @NotNull
  private String password;

  @NotNull
  private String firstName;

  @NotNull
  private String lastName;
}
