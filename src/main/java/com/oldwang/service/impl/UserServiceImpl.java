package com.oldwang.service.impl;

import com.oldwang.common.Comm;
import com.oldwang.common.Res;
import com.oldwang.common.ResEnum;
import com.oldwang.dao.entity.User;
import com.oldwang.dao.factory.DaoFactory;
import com.oldwang.dao.idao.IUserDao;
import com.oldwang.service.iservice.IUserService;

public class UserServiceImpl implements IUserService {

    IUserDao userDao;

    public UserServiceImpl(){
        //创建Dao层接口和工厂模式、业务类
        userDao = (IUserDao) DaoFactory.getInstance(Comm.USER);
    }

    @Override
    public Res userExist(String username) {
        int flag = 0;
        try {
            flag = userDao.exist(username);

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag>0?Res.success(ResEnum.SUCCESS_USER_EXIST):Res.error(ResEnum.ERROR_USER_EXIST);
    }

    @Override
    public Res<User> login(User user) {
        User result = null;
        try{
           result = userDao.login(user);
        }catch (Exception e){
           e.printStackTrace();
        }
        if (result!=null){
            result.setPassword("");
            return Res.success(ResEnum.SUCCESS,result);
        }
        return Res.error(ResEnum.ERROR);
    }
}
