package service.impl;

import common.MyPage;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;


public class UserServiceImpl  implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {

        return userDao.selectByUser(user);
    }

    @Override
    public MyPage<User> listUser(MyPage<User> userMyPage) {
        return userDao.listUser(userMyPage);
    }

    @Override
    public boolean register(User user) {
        return userDao.register(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public User selectUserById(int id) {
        return userDao.selectUserById(id);
    }

    @Override
    public Boolean save(User user) {
        return userDao.save(user);
    }

    @Override
    public Boolean updateImg(User user) {
        return userDao.updateImg(user);
    }
}
