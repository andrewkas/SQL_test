package com.noirix;

public class Main {
    public static void main(String[] args) {

        //Ctrl+W - word checking
        //Alt+Shift - multiple cursor
        //Alt + Mouse movements - multiple rows checking

      // System.out.println("Hello, world!");
      // System.out.println("Hello, world!1111");
      // System.out.println("Hello, world!1111111");
      // System.out.println("String for cherry pick");
      // System.out.println("Dev changes!");
       //  Integer i = new Integer(10);
       //  System.out.println("i1=" + i);
       //  changeInteger(i);
       //  System.out.println("i2=" + i);
       //     }
       //     public static void changeInteger(Integer x) {
       // System.out.println("x1=" + x);
       //         x = new Integer(20);
       //         System.out.println("x2=" + x);

        String s1, s2;
        s1 = "Java";
        s2 = "Java";
        System.out.println("сравнение ссылок " + (s1 == s2)); s1 += '2';
// s1-="a"; //ошибка, вычитать строки нельзя
        s2 = new String(s1);
        System.out.println("сравнение ссылок " + (s1 == s2));
        System.out.println("сравнение значений " + s1.equals(s2));
            } }



