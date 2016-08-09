package com.chisw.controller;

import com.chisw.model.AuthUser;
import com.chisw.model.MyToken;
import com.chisw.model.dao.AuthUserDao;
import com.chisw.model.dao.TokenDao;
import com.chisw.model.dao.daoImpl.HAuthUserDao;
import com.chisw.model.dao.daoImpl.HTokenDao;
import com.chisw.service.CryptService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class AuthUserController {

    private AuthUserDao authUserDao = new HAuthUserDao();

    private TokenDao tokenDao = new HTokenDao();

    public void addToken(MyToken myToken) {

        tokenDao.add(myToken);
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public @ResponseBody
    String getTokenByUserName(@RequestBody AuthUser authUser) throws Exception {

        String login = authUser.getLogin();
        String pass = authUser.getPass();

        if (isRegistered(authUser)) {

            CryptService cryptService = new CryptService();
            String tokenBody = cryptService.someEncrypt(login, pass);

            MyToken myToken = new MyToken();
            myToken.setTokenBody(tokenBody);

            addToken(myToken);
            return tokenBody;
        } else {
            return null;
        }
    }

    public Boolean isRegistered(AuthUser authUser){

        String login = authUser.getLogin();
        String pass = authUser.getPass();

        AuthUser fromBase = authUserDao.getAuthUser(login);
        String passFromBase = fromBase.getPass();

        if (fromBase == null) {
            return false;
        } else if (pass != passFromBase) {
            return false;
        } else {
            return true;
        }
    }

}
