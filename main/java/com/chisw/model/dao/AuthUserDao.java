package com.chisw.model.dao;

import com.chisw.model.AuthUser;

public interface AuthUserDao {

    AuthUser getAuthUser(String login);
}
