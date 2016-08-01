package com.chisw.controller;

import com.chisw.model.dao.UserDao;
import com.chisw.model.dao.daoImpl.HUserDao;
import com.chisw.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping
@RestController
public class ResourceController {

    private UserDao userDao = new HUserDao();

    @RequestMapping(value="/resourcehql/{id}", method = RequestMethod.GET)
    public User getHQLResource(@PathVariable("id") String id) {

        return userDao.getByHQL(Integer.parseInt(id));
    }

    @RequestMapping(value="/resourcesql/{id}", method = RequestMethod.GET)
    public User getSQLResource(@PathVariable("id") String id) {

        return userDao.getBySQL(Integer.parseInt(id));
    }

    @RequestMapping(value="/resources", method = RequestMethod.GET)
    public List<User> getResources() {

        return userDao.getAllByCriteria();
    }

    @RequestMapping(value="/resource", method = RequestMethod.POST)
    public @ResponseBody
    User addResource() {

        String name = "Ivan";
        String surname = "Petrov";
        int age = 30;
        User user = new User(name, surname, age);
        userDao.add(user);
        return user;
    }

    @RequestMapping(value="/resource/{id}", method = RequestMethod.PUT)
    public @ResponseBody
    User updateResource(@PathVariable("id") String id) {

        User user = userDao.getByHQL(Integer.parseInt(id));

        user.setName("AnotherIvan");
        user.setSurname("NotPetrov");
        user.setAge(40);
        userDao.change(user);
        return user;
    }

    @RequestMapping(value="/resource/{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteResource( @PathVariable("id") String id) {

        return userDao.delete(Integer.parseInt(id));
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}