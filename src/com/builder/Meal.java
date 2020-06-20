package com.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * com.builder
 *
 * @author Liuzf
 * @date 2020-06-19 16:47:40
 */
public class Meal {
    private List<Item> items = new ArrayList<Item>();
    private int num = 1;
    public Meal(int num){
        this.num = num;
    }

    /**
     * 添加项目
     * @param item
     */
    public void addItem(Item item){
        items.add(item);
    }

    /**
     * 计算总共花费金额
     * @return
     */
    public int getCost(){
        int a = 0;
        for (Item item : items) {
            a += item.price();
        }
        return a*num;
    }

    public void showMeal(){
        for (Item item : items) {
            System.out.println("餐品是："+item.name()+"，打包方式是："+item.pack().pack()+",价格是："+item.price()+",数量："+num);
        }
    }
}
