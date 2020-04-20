import com.eig.dao.Blog;
import com.eig.mapper.BlogMapper;
import com.eig.utils.IDutils;
import com.eig.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.DateFormat;
import java.util.*;

public class test {
    @Test
    public void getInfo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String , String> hashMap = new HashMap<String , String>();
        hashMap.put("views" , "1000");
        List<Blog> blogs = blogMapper.getBlog(hashMap);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }
    @Test
    public void insertBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog data = new Blog();
        data.setId(IDutils.getId());
        data.setAuthor("lee");
        data.setCreateTime(new Date());
        data.setTitle("test");
        data.setViews(new Random().nextInt());
        blogMapper.insertBlog(data);
        sqlSession.close();
    }
    @Test
    public void getBlogById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String , ArrayList<String>> map = new HashMap<String , ArrayList<String>>();
        ArrayList<String> ids = new ArrayList <String>();
        ids.add("ebd5fcd9583b46ef94bc55708dfe8c40");
        ids.add("32022e021db546619d4c15ac52e77863");
        ids.add("71c971ac9cee486b93ee7364896fdc5a");
        map.put("ids" , ids);
        List<Blog> blogs = blogMapper.getBlogById(map);
        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String , String> map = new HashMap <String, String>();
        map.put("title" , "test123");
        map.put("author" , "lee123");
        map.put("id" , "ebd5fcd9583b46ef94bc55708dfe8c40");
        blogMapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void getBlogByChoose(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession(true);
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String , String> map = new HashMap <String, String>();
        map.put("id" , "ebd5fcd9583b46ef94bc55708dfe8c40");

        map.put("author" , "lz");
        List<Blog> blogs = blogMapper.getBlogByChoose(map);
        System.out.println(blogs);
        //map.put("title" , "test");
        List<Blog> blogList = blogMapper.getBlogByChoose(map);
        System.out.println("==================");
        System.out.println(blogList);
        sqlSession.close();
    }
}
