import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import suncaper.dao.ClazzMapper;
import suncaper.domain.Clazz;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * @author zyq
 * @date 2020/11/4 - 15:49
 */
public class testMybatis2 {
    public static void main(String[] args) throws SQLException, IOException {
        InputStream resourceAsStream = testMybatis2.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getConnection().setAutoCommit(true);

        ClazzMapper clazzMapper = sqlSession.getMapper(ClazzMapper.class);
        //通过班级id查找老师信息
//        Clazz teacherByClazzId = clazzMapper.selectWithTeacherByClazzId(2);
//        System.out.println(teacherByClazzId);


        //通过班级id查找老师和学生的信息
        Clazz teacherAndStudentByClazzId = clazzMapper.selectWithTeacherAndStudentByClazzId(2);
        System.out.println(teacherAndStudentByClazzId);

        sqlSession.close();
        resourceAsStream.close();
    }
}
