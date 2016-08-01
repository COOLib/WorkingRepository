package com.chisw.model.dao;

import com.chisw.model.User;

import java.util.List;

public interface UserDao {

    public User getBySQL(Integer id);

    public User getByHQL(Integer id);

    public List<User> getAllByCriteria();

    public void add(User user);

    public String delete(Integer id);

    public void change(User user);
}
