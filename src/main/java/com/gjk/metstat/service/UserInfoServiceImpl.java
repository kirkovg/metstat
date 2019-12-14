package com.gjk.metstat.service;

import com.gjk.metstat.domain.UserInfo;
import com.gjk.metstat.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;

@Service
public class UserInfoServiceImpl implements UserInfoService {

  @Autowired
  private UserInfoRepository userInfoRepository;

  @Override
  public void createUser(UserInfo user) {
    if (userInfoRepository.existsByUsername(user.getUsername())) {
      throw new ValidationException("User already exists");
    }
    String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
    user.setPassword(encodedPassword);
    userInfoRepository.save(user);
  }

  @Override
  public UserInfo updateUser(UserInfo userInfo) {
    return userInfoRepository.saveAndFlush(userInfo);
  }

  @Override
  public UserInfo getUserInfo(String userName) {
    return userInfoRepository.findByUsername(userName);
  }

  @Override
  public void deleteUser(Long id) {
    userInfoRepository.deleteById(id);
  }
}
