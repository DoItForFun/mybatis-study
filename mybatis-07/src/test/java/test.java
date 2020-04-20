import com.se.dao.Teacher;
import com.se.mapper.TeacherMapper;
import com.se.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void getTeacherInfo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teachers = teacherMapper.getTeacherInfo(1);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }

    @Test
    public void getTeacherList(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> teachers = teacherMapper.getTeacherList(2);
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}
