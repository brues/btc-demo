package btcdemo.btcdemo.model;

import btcdemo.btcdemo.security.IdGenUtils;
import btcdemo.btcdemo.security.Sha256Utils;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 区块测试
 *
 * @author blues
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockTest {

    /**
     * 挖矿测试
     */
    @Test
    public void testMining(){
        System.out.println("\r\n\r\n\r\n");

        // 初始化区块链，并加入一个创世区块
        List<Block> blockChain = new ArrayList<>();
        //生成创世区块
        Block block = new Block(1, System.currentTimeMillis(), new ArrayList<Transaction>(), 1, "1", "1");
        //加入创世区块到区块链里
        blockChain.add(block);
        System.out.println(JSON.toJSONString(blockChain));

        // 创建交易
        List<Transaction> txs = new ArrayList<>();
        Wallet wallet = Wallet.generateWallet();
        //加入系统奖励的交易
        TransactionInput transactionInput = TransactionInput.getSystemTransactionInput();
        TransactionOutput transactionOutput = new TransactionOutput(Transaction.SYSTEM_AWARD, wallet.getHashPubKey());

        Transaction sysTx = new Transaction(IdGenUtils.genId(),transactionInput, transactionOutput);
        txs.add(sysTx);

        // 获取区块链的最后一个区块，并开始解数学难题
        Block lastBlock = blockChain.get(blockChain.size()-1);
        int nonce = 1;
        String hash = "";
        while(true){
            hash = Sha256Utils.sha256(lastBlock.getHash() + JSON.toJSONString(txs) + nonce);
            if (hash.startsWith("0000")) {
                System.out.println("=====计算结果正确，计算次数为：" +nonce+ ",hash:" + hash);
                break;
            }
            nonce++;
            //System.out.println("计算错误，hash:" + hash);
        }

        // 解出后打包交易，然后加入到区块中
        Block newBlock = new Block(lastBlock.getIndex() + 1, System.currentTimeMillis(), txs, nonce, lastBlock.getHash(), hash);
        blockChain.add(newBlock);
        System.out.println("挖矿后的区块链：" + JSON.toJSONString(blockChain));



        System.out.println("\r\n\r\n\r\n");
    }
}
