package com.jacques.lottery;

import com.jacques.lottery.core.action.LotteryAction;
import com.jacques.lottery.core.pojo.Prize;
import com.jacques.lottery.core.pojo.PrizeInfo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 测试抽奖
 *
 * @author Jacques·Fry
 * @version 1.0.0
 * @since 2021/01/29 16:03
 */
public class TestLottery {

    /**
     * 测试1
     *
     * @author Jacques·Fry
     * @since 2021/01/29 16:02
     */
    @Test
    public void test_01() {
        // 可修改参数: 生成参与人
        List<String> users=new ArrayList<>();
        IntStream.range(0,10000).forEach(i->{
            users.add("参与人员");
        });

        // 可修改参数: 生成奖品
        PrizeInfo[] prizes = {
                new PrizeInfo("小米11手机", 20, 1),
                new PrizeInfo("iPhone12", 10, 1),
                new PrizeInfo("MacBook Pro", 5, 1),
                new PrizeInfo("《怪物猎人：崛起》switch游戏卡带", 30, 1),
                new PrizeInfo("谢谢惠顾", 60, Integer.MAX_VALUE),
        };

        System.out.println("参与人数: "+users.size());
        System.out.println("奖品类型数: "+prizes.length);

        long startTime = System.currentTimeMillis();
        users.forEach(user -> {
//            System.out.println("===== 【" + user + "】 参与抽奖=====");
            // 快速抽奖
            Prize lottery = LotteryAction.fastLottery(Arrays.asList(prizes));
//            System.out.println("恭喜【" + user + "】抽中了奖品: " + lottery + "\n");
        });

        long endTime = System.currentTimeMillis();

        System.out.println("消耗时间:" + (endTime - startTime) + " ms");

    }

}
