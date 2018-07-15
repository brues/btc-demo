package btcdemo.btcdemo.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * base64算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base64UtilsTest {

    @Test
    public void testToBase64(){
        System.out.println();
        System.out.println("===== toBase64 begin =====");
        String before = "base64";
        System.out.println(Base64Utils.toBase64(before.getBytes()));
        System.out.println("===== toBase64 end =====");
        System.out.println();
    }

    @Test
    public void testFromBase64() throws Exception {
        System.out.println();
        System.out.println("===== fromBase64 begin =====");
        String before = "base64";
        String after = Base64Utils.toBase64(before.getBytes());
        String afterToBefore = new String(Base64Utils.fromBase64(after));
        System.out.println(afterToBefore);
        System.out.println("===== fromBase64 end =====");
        System.out.println();
    }

}
