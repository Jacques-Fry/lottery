package com.jacques.lottery.core.pojo;

/**
 * 奖品数据
 *
 * @author Jacques·Fry
 * @version 1.0.0
 * @since 2021/1/29 17:23
 */
public class PrizeInfo extends Prize {

    /**
     * 实时数据
     * 中奖概率
     */
    private double probability;

    /**
     * 实时数据
     * 中奖号码起始值 >
     */
    private int startCode;

    /**
     * 实时数据
     * 中奖号码结束值 <=
     */
    private int endCode;

    public PrizeInfo(String name, int probabilityBase, int number) {
        super(name, probabilityBase, number);
    }

    public PrizeInfo(String name, int probabilityBase) {
        super(name, probabilityBase);
    }

    @Override
    public String toString() {
        return super.toString() + " PrizeInfo{" +
                "probability=" + probability +
                ", startCode=" + startCode +
                ", endCode=" + endCode +
                "} ";
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getStartCode() {
        return startCode;
    }

    public void setStartCode(int startCode) {
        this.startCode = startCode;
    }

    public int getEndCode() {
        return endCode;
    }

    public void setEndCode(int endCode) {
        this.endCode = endCode;
    }
}
