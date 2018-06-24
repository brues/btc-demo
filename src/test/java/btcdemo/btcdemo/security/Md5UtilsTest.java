package btcdemo.btcdemo.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * md5算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Md5UtilsTest {

    @Test
    public void testMd5() {
        System.out.println();
        System.out.println("===== md5 begin =====");
        System.out.println();
        System.out.println(Md5Utils.md5("MD5"));
        System.out.println();
        System.out.println("===== md5 end =====");
        System.out.println();
    }

}
