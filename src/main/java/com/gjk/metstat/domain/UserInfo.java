package com.gjk.metstat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  @Column(name = "username", nullable = false)
  private String username;

  @NotNull
  @Column(name = "password", nullable = false)
  private String password;

  @NotNull
  @Column(name = "firstName", nullable = false)
  private String firstName;

  @NotNull
  @Column(name = "lastName", nullable = false)
  private String lastName;
}
