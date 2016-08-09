package com.chisw.model.dao;

import com.chisw.model.MyToken;

public interface TokenDao {

    public String getToken(Integer id);

    public void add(MyToken token);
}
