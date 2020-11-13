package com.wyclass.game;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    private GuessNumber(){

    }

    public static void start(){
       //要完成猜数字的游戏,首先需要有一个要猜的数字,使用随机数生成该数字,范围是1-100
        Random ran = new Random();
        int number =ran.nextInt(100)+1;

        while (true){
            //使用程序实现猜数字,每次均要输入猜测的数字,需要键盘录入实现
            Scanner sc  = new Scanner(System.in);
            System.out.println("请输入你的数字");
            int guessNumber = sc.nextInt();

            //比较输入的数字和系统产生的数字,需要使用分支语句,
            if(guessNumber>number){
                System.out.println("你猜的数字"+guessNumber+"大了");
            }else if(guessNumber<number){
                System.out.println("你猜的数字"+guessNumber+"小了");
            }else{
                System.out.println("恭喜你猜中了");
                break;
            }
        }
    }

}
