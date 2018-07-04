package btcdemo.btcdemo.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 钱包实体类测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletTest {


    @Test
    public void testWallet(){
        System.out.println();
        System.out.println();
        System.out.println("wallet test begin");
        Wallet wallet = Wallet.generateWallet();
        System.out.println(wallet.getAddress());
        System.out.println("wallet test end");
        System.out.println();
        System.out.println();
    }

}
