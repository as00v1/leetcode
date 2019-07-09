package com.qiaohx.test;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        List<String> strList = Arrays.asList("YangHang", "AnXiaoHei", "LiuPengFei");
//
//        long count = strList.stream().filter("AnXiaoHei"::equals).count();
//        System.out.println(count);


        for (int i = 0; i < 3; i++) {
            Thread.sleep(3000);
            System.out.println(i);
        }
    }
}
