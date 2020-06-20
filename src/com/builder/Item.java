package com.builder;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 15:59:36
 */
public interface Item {
    /**
     * 条目名称
     * @return
     */
    String name();

    /**
     * 打包方式
     * @return
     */
    Packing pack();

    /**
     * 价钱
     * @return
     */
    int price();
}
