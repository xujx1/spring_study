import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pojo.User;
import service.impl.CdPlayImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class TestXml {

    @Autowired
    private User user;

    @Autowired
    private CdPlayImpl cdPlay;

    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }


    @org.junit.Test
    public void user() {
        assert user != null;
        System.out.println(user.toString());
    }

    @org.junit.Test
    public void play() {
        assert cdPlay != null;
        cdPlay.play();
    }

}
