package part02.chapt05;

import part02.Part2Util;
import part02.Trader;
import part02.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by lssemail on 2017/9/25.
 */
public class StreamTest05 {

    public static void main(String[] args) {
        test07();
    }

    //找出2011年发生的所有交易，并按交易额排序（从低到高）。
    public static void test01(){

        List<Transaction> transactionList = Part2Util.getTransactionList();
        List<Transaction> list = transactionList.stream().filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    //交易员都在哪些不同的城市工作过
    public static void test02(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        List<String> list = transactionList.stream().map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    //查找所有来自于剑桥的交易员，并按姓名排序
    public static void test03(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        List<Trader> list = transactionList.stream().map(t -> t.getTrader())
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);
    }

    //4返回所有交易员的姓名字符串，按字母顺序排序
    public static void test04(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        String names = transactionList.stream().map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + ","+ n2);
        System.out.println(names);
    }

    //有没有交易员是在米兰工作的
    public static void test05(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        boolean has = transactionList.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println(has);
    }

    //打印生活在剑桥的交易员的所有交易额
    public static void test06(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        transactionList.stream().filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }

    //所有交易中，最高的交易额是多少
    public static void test07(){
        List<Transaction> transactionList = Part2Util.getTransactionList();
        Optional<Integer> max =  transactionList.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max.get());
    }
}
