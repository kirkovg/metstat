package com.gjk.metstat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponseDto {
  @NotNull
  private String token;
}
