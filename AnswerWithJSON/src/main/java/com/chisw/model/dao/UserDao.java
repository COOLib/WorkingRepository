package com.chisw.model.dao;

import com.chisw.model.User;

import java.util.List;

public interface UserDao {

    public User getSQL(Integer id);

    public User getHQL(Integer id);

    public List<User> getAll();

    public void add(User user);

    public String delete(Integer id);

    public void change(User user);
}
