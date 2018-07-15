package btcdemo.btcdemo.security;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * base58算法测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Base58UtilsTest {

    @Test
    public void testToBase64(){
        System.out.println();
        System.out.println("===== toBase58 begin =====");
        System.out.println();
        System.out.println(Base58Utils.toBase58("base582323423424234234234234234".getBytes()));
        System.out.println();
        System.out.println("===== toBase58 end =====");
        System.out.println();
    }

    @Test
    public void testFromBase64(){
        System.out.println();
        System.out.println("===== fromBase58 begin =====");
        System.out.println();
        System.out.println(new String(Base58Utils.fromBase58(Base58Utils.toBase58("base58".getBytes()))));
        System.out.println();
        System.out.println("===== fromBase58 end =====");
        System.out.println();
    }

}
