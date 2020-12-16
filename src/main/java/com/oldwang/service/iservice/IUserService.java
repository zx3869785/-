package com.oldwang.service.iservice;

import com.oldwang.common.Res;
import com.oldwang.dao.entity.User;

public interface IUserService {
    Res userExist(String username);

    Res<User> login(User user);
}
