package com.chisw.service;

import com.chisw.model.AuthUser;
import com.chisw.model.dao.AuthUserDao;
import com.chisw.model.dao.daoImpl.HAuthUserDao;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CryptService {

    private AuthUserDao authUserDao = new HAuthUserDao();
    private String secretKey = "key123";
    private Map<String, Object> tokenData;

    public String someEncrypt(String authUserLogin, String password) throws Exception {

        if (authUserLogin == null || password == null) {

            return null;
        }

        AuthUser authUser = authUserDao.getAuthUser(authUserLogin);

        tokenData = new HashMap<>();

        if (password.equals(authUser.getPass())) {

            tokenData.put("authUser",authUser.getId().toString());
            tokenData.put("userLogin", authUser.getLogin());
            tokenData.put("password", authUser.getPass());
            tokenData.put("site", authUser.getSite());

            JwtBuilder jwtBuilder = Jwts.builder();

            jwtBuilder.setClaims(tokenData);

            String token = jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey).compact();

            return token;
        }
        else {
            throw new Exception("Authentication error");
        }
    }

    public AuthUser decrypt() {

        AuthUser user = new AuthUser();
        user.setId(Integer.parseInt(tokenData.get("authUser").toString()));
        user.setLogin(tokenData.get("userLogin").toString());
        user.setPass(tokenData.get("password").toString());
        user.setSite(tokenData.get("site").toString());

        return user;
    }
}
