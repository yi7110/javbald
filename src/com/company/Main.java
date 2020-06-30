package com.company;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuzf
 * @date 2020年6月12日09:25:41
 */
public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

//        excelImtest();

        calDemo();
    }

    /**
     * 排序冒泡算法
     */
    public static void OrderNum(){
        int[] ints = {1,4,2,3,6,8};
        for (int a=0; a<ints.length; a++)
        {
            for (int b=a+1; b<ints.length; b++)
            {
                if (ints[a]<ints[b]){
                    int c = ints[a];
                    ints[a] = ints[b];
                    ints[b] = c;
                }
            }
        }
        for (int i:ints) {
            System.out.println(i);
        }
    }

    public static void excelImtest(){
        ExcelImportDemo re = new ExcelImportDemo();
        //忽略前1行
        List<List<String>> list = re.read("C:\\Users\\Administrator\\Desktop\\d.xlsx", 1);

        // 遍历读取结果
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print("第" + (1+i) + "行");

                List<String> cellList = list.get(i);
                for (int j = 0; j < cellList.size(); j++) {
                    System.out.print(" 第" + (j + 1) + "列值：");
                    System.out.print(" " + cellList.get(j));
                }
                System.out.println();
            }
        }
    }

    public static void calDemo(){
        Calendar c = Calendar.getInstance();
//        System.out.println(c.getWeekYear());
//        System.out.println(c.getTime());
        System.out.println(c.get(Calendar.YEAR));
        System.out.println(c.get(Calendar.MONTH));
        System.out.println(c.get(Calendar.DATE));
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
        System.out.println(c.get(Calendar.DAY_OF_WEEK));
//        System.out.println(c.getWeekYear());
//        System.out.println(c.getWeekYear());
//        System.out.println(c.getWeekYear());
    }
}
