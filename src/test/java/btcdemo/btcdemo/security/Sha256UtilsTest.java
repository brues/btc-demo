package btcdemo.btcdemo.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * sha256算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Sha256UtilsTest {


    @Test
    public void testSha256(){
        System.out.println();
        System.out.println("===== sha256 begin =====");
        System.out.println(Sha256Utils.sha256("sha256"));
        System.out.println("===== sha256 end =====");
        System.out.println();
    }
}
