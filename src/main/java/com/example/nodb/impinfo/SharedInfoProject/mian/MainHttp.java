package com.example.nodb.impinfo.SharedInfoProject.mian;

import static org.springframework.http.HttpStatus.*;

public class MainHttp {
    public static void main(String[] args) {
        System.out.println(OK.value()==200);//true
        System.out.println(OK);//200 OK
        System.out.println(OK.equals("OK"));//false
        System.out.println(OK.toString().equalsIgnoreCase("ok"));//false
        System.out.println(OK.name());//OK
        System.out.println(OK.name().equalsIgnoreCase("ok"));//true
    }
}
