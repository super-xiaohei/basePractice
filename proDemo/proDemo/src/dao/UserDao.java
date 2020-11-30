package dao;

import common.MyPage;
import domain.User;

import java.util.List;

public interface UserDao {
    User selectByUser(User user);

    MyPage<User> listUser(MyPage<User> userMyPage);

    boolean register(User user);

    boolean deleteById(int id);

    User selectUserById(int id);

    Boolean save(User user);

    Boolean updateImg(User user);
}
