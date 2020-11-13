package com.wyclass.game;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
   需求：请写程序实现猜数字小游戏只能试玩3次，如果还想玩，提示：游戏试玩已结束，想玩请充值(www.itcast.cn)
思路：
写一个游戏类，里面有一个猜数字的小游戏
写一个测试类，测试类中有main()方法，main()方法中写如下代码：
从文件中读取数据到Properties集合，用load()方法实现
	文件已经存在：game.txt
	里面有一个数据值：count=0
通过Properties集合获取到玩游戏的次数
判断次数是否到到3次了
	如果到了，给出提示：游戏试玩已结束，想玩请充值(www.itcast.cn)
	如果不到3次：
		次数+1，重新写回文件，用Properties的store()方法实现
		玩游戏
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
     //从文件中读取数据到Properties集合中,使用load()方法实现
        Properties prop = new Properties();
        FileReader fr= new FileReader("game.txt");
        prop.load(fr);
        fr.close();
        //通过Properties集合获取到玩游戏的次数
        String count = prop.getProperty("count");
        int number = Integer.parseInt(count);
        System.out.println(number);
        if(number>=3){
            System.out.println("游戏试玩已结束,想玩请充值(www.itheima.cn)");
        }else{
            //玩游戏
            GuessNumber.start();
            //次数+1,重新写会问文件, 使用Properties的store()方法实现
            number++;
            System.out.println(number);
            prop.setProperty("count",String.valueOf(number));
            FileWriter fw = new FileWriter("game.txt");
            prop.store(fw,null);
            fw.close();
        }
    }
}
