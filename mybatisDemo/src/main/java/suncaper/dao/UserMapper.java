package suncaper.dao;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import suncaper.domain.User;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Map;

/**
 * @author zyq
 * @date 2020/11/3 - 11:45
 */
public interface UserMapper {
    User selectUserById(int id );
    List<User> selectUserByAddr(String address);

    int deleteById(@Param("id") Integer id, @Param("address") String address);

    int inserUser(User user);

    User selectByUser(@Param("u") User user);

    List<User> selectByLikeName();

    List<User> selectByName(@Param("name") String username);
    @MapKey("id")
    Map<Integer, User> selectAllMapUser();

    Map<String, Object> selectOneMapUser(int i);

    List<Map<String, Object>> selectAllMapCol();

    List<User> selelctBySome(@Param("user") User user);

    int deleteByIds(@Param("idList") List<Integer> idList);

    int inserUsers(@Param("userList") List<User> userList);
}
