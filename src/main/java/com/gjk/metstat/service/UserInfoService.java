package com.gjk.metstat.service;

import com.gjk.metstat.domain.UserInfo;

public interface UserInfoService {

  void createUser(UserInfo userInfo);

  UserInfo updateUser(UserInfo userInfo);

  UserInfo getUserInfo(String userName);

  void deleteUser(Long id);
}
