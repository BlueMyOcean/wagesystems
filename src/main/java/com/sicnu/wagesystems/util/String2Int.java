package com.sicnu.wagesystems.util;

public class String2Int {

    public static int  string2int(String s)
    {
        System.out.println(s);
        if (s.equals("男"))
            return 1;
        else
            return 0;


    }

    public static String  int2string(long i)
    {
        if (i==1)
            return "男";
        else
            return "女";


    }



}
