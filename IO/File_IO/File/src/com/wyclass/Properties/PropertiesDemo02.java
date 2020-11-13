package com.wyclass.Properties;

import java.util.Properties;
import java.util.Set;

/*
String getProperty​(String key) 使用此属性列表中指定的键搜索属性。
Object setProperty​(String key, String value) 调用 Hashtable方法 put 。
Set<String> stringPropertyNames​() 从该属性列表中返回一个不可修改的键集，其中键及其
对应的值是字符串，包括默认属性列表中的不同键，如果尚未从主属性列表中找到相同名称的键。
 */
public class PropertiesDemo02 {
    public static void main(String[] args) {
        Properties prop = new Properties();
        //String getProperty​(String key) 使用此属性列表中指定的键搜索属性。
        prop.setProperty("itheima001","林青霞");
        prop.setProperty("itheima002","张曼玉");
        prop.setProperty("itheima003","王祖贤");

       //Object setProperty​(String key, String value) 调用 Hashtable方法 put 。
        String name = prop.getProperty("itheima002");
        System.out.println(name);

     //Set<String> stringPropertyNames​()
        Set<String> strings = prop.stringPropertyNames();
        for (String key :strings){
            String value = prop.getProperty(key);
            System.out.println(value);

        }
    }
}
