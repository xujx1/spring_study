import config.Config;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.IPerformance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class Test {


    @Autowired
    private IPerformance performance;

    @Before
    public void before() {
        System.out.println("=====================================");
    }

    @After
    public void after() {
        System.out.println("=====================================");
    }


    @org.junit.Test
    public void show() {
        assert performance != null;
        System.out.println( performance.show("许金鑫"));
    }
}
