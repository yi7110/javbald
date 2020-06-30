package com.base;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DeflaterOutputStream;

/**
 * com.base
 *
 * @author Liuzf
 * @date 2020-06-20 12:33:05
 */
public class Main {

    public static void stringReplace(String text){
        text=text+"c";
    }
    public static void bufferReplace(StringBuffer text){
        text=text.append("c");
    }
    public static void main(String args[]){
//        String textString=new String("java");
//        StringBuffer textBuffer=new StringBuffer("java");
//        stringReplace(textString);
//        bufferReplace(textBuffer);
//        System.out.println(textString+textBuffer);
//          sumzero1();
//        int chr1 = new int;
//        char[] chr2 = new char;
//        char[] chr3 = {'A','B','C'};
//        threeSum();
//        fordemo();
//        fordemo0();
//        fordemo1();
        System.out.println(new Integer(-33).toString());
    }

    public  static void maxSubArray()  {
       int array[] =  {-2,1,-3,4,-1,2,1,-5,4};
       //遍历总和
       int totalsum = 0;
       //最终的起始下标
       int totalbegindex = 0;
        //最终的结束下标
       int totalastindex = 0;
        for (int i = 0; i < array.length; i++) {
            //用来轮训的起始和
            int tmpsum = array[i];
            //轮训的最大和
            int maxsum = array[i];
            //轮训的起始下标
            int begindex = i;
            //轮训的结束下标
            int lastindex = i;
            for (int j = i+1; j <array.length; j++){
                //每次轮训加上后一位的和
                 tmpsum = tmpsum+array[j];
                 //如果比最大和大，就修改结束下标，并且修改最大和的值
                if(tmpsum > maxsum){
                    maxsum = tmpsum;
                    lastindex = j;
                }
            }
            //第一次默认
            if(i == 0){
                totalsum = maxsum;
                totalbegindex = begindex;
                totalastindex = lastindex;
            }
            //之后比较最大值，修改起始下标和结束下标
            else{
                if(totalsum < maxsum){
                    totalsum = maxsum;
                    totalbegindex = begindex;
                    totalastindex = lastindex;
                }
            }
        }
        int finalarray[] = new int[totalastindex-totalbegindex+1];
        for (int i = 0; i < finalarray.length; i++) {
            finalarray[i] = array[i+totalbegindex];
        }
        System.out.println("最大值为"+totalsum);
        System.out.println("数组为：");
        for (int i : finalarray) {
            System.out.print(i+",");
        }
    }

    public  static void sumzero()  {
        int[] array =  {-1, 0, 1, 2, -1, -4};
        for (int i = 0; i < array.length-2; i++) {
            int tmpsum = array[i];
            int begindex = i;
            boolean flag = false;
            tmpsum = tmpsum+array[i+1]+array[i+2];
            if(tmpsum == 0){
                int[] finalarray = new int[3];
                for (int a = 0; a < finalarray.length; a++) {
                    finalarray[a] = array[a+begindex];
                }
                    System.out.println("数组为：");
                    for (int f : finalarray) {
                        System.out.print(f+",");
                        System.out.println();
                    }
            }

        }

    }

    public  static List<List<Integer>> sumzero1()  {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int[] array =  {-1, 0, 1, 2, -1, -4};
        for (int i = 0; i < array.length-2; i++) {
            int a = array[i];
            for (int j = i+1; j < array.length-1; j++) {
                int b =  array[j];
                for (int z = j+1; z< array.length;z++) {
                    int  c = array[z];
                    if(a + b + c == 0){
                        List<Integer> list1 = new ArrayList<Integer>();
                        addl(a, b, c, list1);
                        if(!CollectionUtils.isEmpty(list)){
                            for (List<Integer> list2 : list) {
                                if(list2.containsAll(list1) && list1.containsAll(list2)){
                                    continue;
                                }
                            }
                        }
                        list.add(list1);
                        System.out.println("三元组为：");
                        System.out.println(a+","+b+","+c);
                    }
                }
            }
            }
        return list;
        }

    private static void addl(int a, int b, int c, List<Integer> list1) {
        list1.add(a);
        list1.add(b);
        list1.add(c);
    }

    static ArrayList<ArrayList<Integer>> threeSum() {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();;
        int[] nums =  {-1, 0, 1, 2, -1, -4};
        int a,b,c;
        if (nums.length == 0) {
            return  results;
        }

        Arrays.sort(nums);
       
        if (nums[0] > 0) {
            return results;
        }

        for (int i = 0; i < ((int)nums.length - 2); ++i) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue; // 去重复
            }
            for (int j = i + 1, k = nums.length - 1; j < k;) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    ++j;  // 去重复
                    continue;
                }

                if (k < nums.length - 1 && nums[k + 1] == nums[k]) {
                    --k;  // 去重复
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                a = nums[i];
                b = nums[j];
                c = nums[k];
                if (0 == sum) {
                    ArrayList<Integer> list1 = new ArrayList<Integer>(3);
                    list1.add(nums[i]);
                    list1.add(nums[j]);
                    list1.add(nums[k]);
                    results.add(list1);
                    System.out.println(a+","+b+","+c);
                    ++j;
                    --k;
                }
                else if (sum > 0) {
                    --k;
                }
                else {
                    ++j;
                }
            }
        }

        return results;
    }
    static void   fordemo(){
        int a = 0;
        for (int i = 0; i < 99; i++) {
            a = a ++;
        }
        System.out.println(a);
    }

    static void   fordemo0(){
        int a = 0;
        for (int i = 0; i < 99; i++) {
            a = ++a;
        }
        System.out.println(a);
    }

    static void fordemo1(){
        Integer a = 0;
        int b = 0;
        for (int i = 0; i < 99; i++) {
            a = a ++;
            b = a ++;
        }
        System.out.println(a);
        System.out.println(b);
//        版权声明：本文为CSDN博主「IT云清」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/weixin_39800144/article/details/80749123
    }
}
