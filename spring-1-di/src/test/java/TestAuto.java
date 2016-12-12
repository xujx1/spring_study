import config.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.impl.CdPlayImpl;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class TestAuto {

    @Autowired
    private CdPlayImpl cdPlay;

    @Autowired
    private User user;


    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }

    @org.junit.Test
    public void play() {
        assert cdPlay != null;
        cdPlay.play();
    }


    @org.junit.Test
    public void user() {
        assert user != null;
        System.out.println(user.toString());
    }

    public static void main(String[] args) throws Exception {
        java.util.List<User> userList = new ArrayList<User>();
        System.out.println(userList==userList.getClass().newInstance());
    }
}
