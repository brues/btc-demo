package btcdemo.btcdemo.model;

import btcdemo.btcdemo.security.IdGenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 交易类测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {


    @Test
    public void testTransaction(){
        Wallet receiver = Wallet.generateWallet();

        TransactionInput transactionInput = TransactionInput.getSystemTransactionInput();
        TransactionOutput transactionOutput = new TransactionOutput(10, receiver.getHashPubKey());

        Transaction transaction = new Transaction(IdGenUtils.genId(),transactionInput, transactionOutput);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(transaction.coinbaseTx());
        transaction.sign(receiver.getPrivateKey(), transaction);
        System.out.println(transaction.verify(transaction));
        System.out.println();
        System.out.println();
        System.out.println();
    }


}
