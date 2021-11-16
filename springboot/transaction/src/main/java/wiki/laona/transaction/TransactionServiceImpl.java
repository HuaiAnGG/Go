package wiki.laona.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author laona
 * @description
 * @create 2021-11-11 22:28
 **/
@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionService transactionService;

    @Transactional
    @Override
    public void transactionMethod() throws InterruptedException {
        System.out.println("do something....");
        System.out.println(new SimpleDateFormat("1. yyyy-MM-dd HH:mm:ss").format(new Date()));
        Thread.sleep(1000);
        System.out.println("will calling async method....");
        System.out.println(new SimpleDateFormat("2. yyyy-MM-dd HH:mm:ss").format(new Date()));
        transactionService.asyncFunMethod();
        System.out.println(new SimpleDateFormat("3. yyyy-MM-dd HH:mm:ss").format(new Date()));
        Thread.sleep(8000);
        System.out.println("transaction method done!");
    }

    @Async
    @Override
    public void asyncFunMethod() throws InterruptedException {
        System.out.println(new SimpleDateFormat("4. yyyy-MM-dd HH:mm:ss").format(new Date()));
        Thread.sleep(5000);
        System.out.println("async method done!");
    }

    @Autowired
    @Lazy
    public void setTransactionService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
}
