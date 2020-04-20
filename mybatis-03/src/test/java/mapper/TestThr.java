package mapper;

import com.thr.mapper.UserMapper;
import com.thr.pro.User;
import com.thr.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
public class TestThr {
    static Logger logger = Logger.getLogger(UserMapper.class);
    @Test
    public void getAllUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getAllUsers();
        for (User user : userList) System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testLog4J(){
        logger.info("info:into testLog4J");
        logger.debug("debug:into testLog4J");
        logger.error("error:into testLog4J");
    }
    @Test
    public void getUserListLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String , Integer> map = new HashMap <String , Integer>();
        map.put("startIndex" , 0);
        map.put("pageSize" , 2);
        List<User> userList = userMapper.getUserLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0,2);
        List<User> userList = sqlSession.selectList("com.thr.mapper.UserMapper.getUserRowBounds" , null  , rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
