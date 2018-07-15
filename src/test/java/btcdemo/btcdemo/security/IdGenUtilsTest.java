package btcdemo.btcdemo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * uuid测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IdGenUtilsTest {


    @Test
    public void testGenId(){
        System.out.println();
        System.out.println();
        System.out.println(IdGenUtils.genId());
        System.out.println();
        System.out.println();
    }

}
