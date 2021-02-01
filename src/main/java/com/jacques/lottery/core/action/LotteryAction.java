package com.jacques.lottery.core.action;

import com.jacques.lottery.core.pojo.Prize;
import com.jacques.lottery.core.pojo.PrizeInfo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 抽奖的方法
 *
 * @author Jacques·Fry
 * @version 1.0.0
 * @since 2021/01/29 16:21
 */
public class LotteryAction {


    /**
     * 快速抽奖
     *
     * @param prizes 奖
     * @return {@link Prize }
     * @author Jacques·Fry
     * @since 2021/01/29 16:58
     */
    public static Prize fastLottery(List<PrizeInfo> prizes) {
        // 整理抽奖数据
        List<PrizeInfo> prizeList = LotteryAction.statisticsPrize(prizes);
        int probabilitySum = prizeList.stream().mapToInt(Prize::getProbabilityBase).sum();
        // 生成中奖号码
        int prizeCode = LotteryAction.generatePrizeCode(1, probabilitySum);
        // 验证奖品
        return LotteryAction.verifyPrize(prizeList, prizeCode);
    }

    /**
     * 整理统计奖品数据
     *
     * @param prizes 奖
     * @author Jacques·Fry
     * @since 2021/01/28 14:52
     */
    public static List<PrizeInfo> statisticsPrize(List<PrizeInfo> prizes) {
        List<PrizeInfo> prizeList = prizes.stream().filter(item -> item.getNumber() != 0).collect(Collectors.toList());
        int probabilitySum = prizeList.stream().mapToInt(Prize::getProbabilityBase).sum();
        // 概率基数起始值
        int probability = 1;
        for (PrizeInfo item : prizeList) {
            // 计算中奖概率
            BigDecimal a = new BigDecimal(item.getProbabilityBase() * 100);
            BigDecimal b = new BigDecimal(probabilitySum);
            BigDecimal divide = a.divide(b, 3, RoundingMode.HALF_DOWN);
            item.setProbability(divide.doubleValue());
            // 计算中奖号码区间
            item.setStartCode(probability);
            item.setEndCode(item.getProbabilityBase() + probability);
            probability = item.getEndCode();
        }
        return prizeList;
    }


    /**
     * 验证奖品
     *
     * @param prizes    奖
     * @param prizeCode 中奖号码
     * @return {@link Prize }
     * @author Jacques·Fry
     * @since 2021/01/29 16:52
     */
    public static Prize verifyPrize(List<PrizeInfo> prizes, int prizeCode) {
        // 判断奖品
        Prize lottery = null;
        for (PrizeInfo item : prizes) {
            if (prizeCode >= item.getStartCode() && prizeCode < item.getEndCode()) {
                lottery = item;
                item.setNumber(item.getNumber() - 1);
                break;
            }
        }
        return lottery;
    }

    /**
     * 生成一个中奖号码
     *
     * @param m m
     * @param n n
     * @return int
     * @author Jacques·Fry
     * @since 2021/01/29 15:48
     */
    public static int generatePrizeCode(int m, int n) {
        // 生成随机数 m-n n除外 Math.random()*(n-m)+m
        return (int) (Math.random() * (n - m) + m);
    }
}
