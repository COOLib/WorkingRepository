package com.chisw.controller;

import com.chisw.model.User;
import com.chisw.model.dao.UserDao;
import com.chisw.model.dao.daoImpl.HUserDao;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ResourceController {

    private UserDao userDao = new HUserDao();

    @Secured("ROLE_USER")
    @RequestMapping(value = "/resourcehql/{id}", method = RequestMethod.GET)
    public User getHQLResource(@PathVariable("id") String id) {

        return userDao.getHQL(Integer.parseInt(id));
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/resourcesql/{id}", method = RequestMethod.GET)
    public User getSQLResource(@PathVariable("id") String id) {

        return userDao.getSQL(Integer.parseInt(id));
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/resources", method = RequestMethod.GET)
    public List<User> getResources() {

        return userDao.getAll();
    }

    @Secured("ROLE_USER")
    @RequestMapping(value = "/resource", method = RequestMethod.POST)
    public
    @ResponseBody
    User addResource() {

        String name = "Ivan";
        String surname = "Petrov";
        int age = 30;
        User user = new User(name, surname, age);
        userDao.add(user);
        return user;
    }

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.PUT)
    public
    @ResponseBody
    User updateResource(@PathVariable("id") String id) {

        User user = userDao.getHQL(Integer.parseInt(id));

        user.setName("AnotherIvan");
        user.setSurname("NotPetrov");
        user.setAge(40);
        userDao.change(user);
        return user;
    }

    @RequestMapping(value = "/resource/{id}", method = RequestMethod.DELETE)
    public
    @ResponseBody
    String deleteResource(@PathVariable("id") String id) {

        return userDao.delete(Integer.parseInt(id));
    }
}