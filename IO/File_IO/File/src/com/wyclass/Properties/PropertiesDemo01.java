package com.wyclass.Properties;

import java.util.Properties;
import java.util.Set;

/*
   Properties类表示一组持久的属性。 Properties可以保存到流中或从流中加载
    */
public class PropertiesDemo01 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //存储元素
        prop.put("itmeima001","林青霞");
        prop.put("itheima002","张曼玉");
        prop.put("itheima003","王祖贤");

        Set<Object> keyset= prop.keySet();
        for (Object key : keyset) {
            Object value = prop.get(key);
            System.out.println(key+","+value);
        }
    }
}
