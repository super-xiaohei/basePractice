package suncaper.admin.service;

import suncaper.admin.dao.UserDao;
import suncaper.admin.entity.Category;
import suncaper.admin.entity.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public boolean regist(User user) {
        //调用dao里面的inser方法
        return userDao.insert(user) > 0;
    }

    public User login(User user) {
        return userDao.selectByUser(user);
    }

    public boolean updatePwd(User currentLoginUser) {
        return userDao.updatePwd(currentLoginUser) > 0;
    }

    public boolean addCategory(Category category) {
        return userDao.insertCategory(category) > 0;
    }
}
