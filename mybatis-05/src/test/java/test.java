import com.lizhe.dao.Student;
import com.lizhe.mapper.StudentMapper;
import com.lizhe.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void getStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentList();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void getStudentSet(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.getStudentSet();
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
