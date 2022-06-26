package com.xiaonicode.java14;

import org.junit.Test;

/**
 * NullPointerExceptions 的测试类
 * <p>
 * JVM 参数: -XX:+ShowCodeDetailsInExceptionMessages, 显示 NullPointerException 的提示信息,<br/>
 * 该参数在 Java 14 及之后的版本下已默认开启
 *
 * @author xiaoni
 * @see <a href="https://openjdk.org/jeps/358">JEP 358: Helpful NullPointerExceptions</a>
 * @since 2022-06-25
 */
public class NullPointerExceptionsTest {

    @Test
    public void test1() {
        // var bank = new Bank(new Consumer(new Account(1000)));
        var bank = new Bank(new Consumer());
        bank.getConsumer().getAccount().withdraw(200);
    }

}

class Bank {

    private Consumer consumer;

    public Bank() {
    }

    public Bank(Consumer consumer) {
        this.consumer = consumer;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

}

class Consumer {

    private Account account;

    public Consumer() {
    }

    public Consumer(Account account) {
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

class Account {

    private double balance;

    public Account() {
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            System.out.println("成功取款: " + amt);
        } else {
            System.out.println("余额不足, 取款失败");
        }
    }

}
