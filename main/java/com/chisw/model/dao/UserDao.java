package com.chisw.model.dao;

import com.chisw.model.User;

import java.util.List;

public interface UserDao {

    User getSQL(Integer id);

    User getHQL(Integer id);

    List<User> getAll();

    void add(User user);

    String delete(Integer id);

    void change(User user);
}
