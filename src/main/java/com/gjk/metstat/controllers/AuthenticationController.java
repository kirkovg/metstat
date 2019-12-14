package com.gjk.metstat.controllers;

import com.gjk.metstat.config.JwtTokenHelper;
import com.gjk.metstat.domain.UserInfo;
import com.gjk.metstat.dto.CreateUserDto;
import com.gjk.metstat.dto.JwtRequestDto;
import com.gjk.metstat.dto.JwtResponseDto;
import com.gjk.metstat.service.JwtUserDetailsServiceImpl;
import com.gjk.metstat.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@CrossOrigin
public class AuthenticationController {

  @Autowired
  private JwtUserDetailsServiceImpl jwtUserDetailsService;

  @Autowired
  private JwtTokenHelper jwtTokenHelper;

  @Autowired
  private ConversionService conversionService;

  @Autowired
  private UserInfoService userInfoService;

  @RequestMapping(value = "/signin", method = POST)
  public JwtResponseDto createAuthenticationToken(@RequestBody @Valid JwtRequestDto jwtRequestDto) throws Exception {
    jwtUserDetailsService.authenticate(jwtRequestDto.getUsername(), jwtRequestDto.getPassword());
    final UserDetails userDetails = jwtUserDetailsService
      .loadUserByUsername(jwtRequestDto.getUsername());
    final String token = jwtTokenHelper.generateToken(userDetails);
    return new JwtResponseDto(token);
  }

  @RequestMapping(value = "/signup", method = POST)
  public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserDto userDto) {
    UserInfo userInfo = conversionService.convert(userDto, UserInfo.class);
    userInfoService.createUser(userInfo);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }
}
