package com.gjk.metstat.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class JwtRequestDto {

  @NotNull
  private String username;

  @NotNull
  private String password;
}
