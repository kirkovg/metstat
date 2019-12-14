package com.gjk.metstat.converters;

import com.gjk.metstat.domain.UserInfo;
import com.gjk.metstat.dto.CreateUserDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateUserDtoToUserInfoConverter implements Converter<CreateUserDto, UserInfo> {

  @Override
  public UserInfo convert(CreateUserDto dto) {
    UserInfo user = new UserInfo();
    user.setUsername(dto.getUsername());
    user.setPassword(dto.getPassword());
    user.setFirstName(dto.getFirstName());
    user.setLastName(dto.getLastName());
    return user;
  }
}
