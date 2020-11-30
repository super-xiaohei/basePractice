import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.suncaper.demo.domain.User;
import net.suncaper.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author zyq
 * @date 2020/11/5 - 16:12
 */

@RunWith(SpringJUnit4ClassRunner.class) //使用Springtest测试框架
@ContextConfiguration("/config/spring-config.xml")
public class TestSpringMybatisDemo {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void hh(){
        User user = userMapper.selectByPrimaryKey(2);
        System.out.println(user);

        System.out.println("--------------------------------------------------");
        PageHelper.startPage(2,2);
        List<User> users = userMapper.selectByExample(null);
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        int size = userPageInfo.getSize();
        System.out.println("--------------------------------------------------");
        System.out.println(size);
        System.out.println(userPageInfo);
    }

}
