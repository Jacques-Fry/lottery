package com.jacques.lottery.core.pojo;

import java.io.Serializable;

/**
 * 奖品
 *
 * @author Jacques·Fry
 * @version 1.0.0
 * @since 2021/1/28 14:18
 */
public class Prize implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 奖品名称
     */
    private String name;

    /**
     * 中奖概率基数
     */
    private int probabilityBase;

    /**
     * 实时数据
     * 奖品剩余数量
     */
    private int number;

    @Override
    public String toString() {
        return "Prize{" +
                "name='" + name + '\'' +
                ", probabilityBase=" + probabilityBase +
                ", number=" + number +
                '}';
    }

    public Prize(String name, int probabilityBase, int number) {
        this.name = name;
        this.probabilityBase = probabilityBase;
        this.number = number;
    }

    public Prize(String name, int probabilityBase) {
        this.name = name;
        this.number = 1;
        this.probabilityBase = probabilityBase;
    }

    public Prize() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProbabilityBase() {
        return probabilityBase;
    }

    public void setProbabilityBase(int probabilityBase) {
        this.probabilityBase = probabilityBase;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
