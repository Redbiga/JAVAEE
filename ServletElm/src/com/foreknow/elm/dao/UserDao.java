package com.foreknow.elm.dao;

import com.foreknow.elm.po.Food;
import com.foreknow.elm.po.User;

public interface UserDao {
    /**
     * 根据用户编号与密码查询用户信息
     * @param userId
     * @param password
     * @return
     * @throws Exception
     */
    public User getUserByIdByPass(String userId, String password)throws Exception;

    /**
     * 功能：根据用户编号查询用户表返回的行数
     * @param userId
     * @return
     * @throws Exception
     */
    public int getUserById(String userId)throws  Exception;

    /**
     * 功能：向用户表中添加一条记录
     * @param userId
     * @param password
     * @param userName
     * @param userSex
     * @return
     * @throws Exception
     */
    public int saveUser(String userId,String password,String userName,int userSex)throws Exception;
}
