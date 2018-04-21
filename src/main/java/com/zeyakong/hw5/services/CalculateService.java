package com.zeyakong.hw5.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by Zeya Kong
 * On 4/5/2018 10:37 PM.
 */
@Service
public class CalculateService {

//    public static void main(String[] args) {
//        BigDecimal b1 = BigDecimal.valueOf(7318);
//        System.out.println(b1.pow(153));
//    }

    public String add(int x,int y){
        BigDecimal b1 = new BigDecimal(Integer.toString(x));
        BigDecimal b2 = new BigDecimal(Integer.toString(y));
        return b1.add(b2).toString();
    }

    public String mul(int x, int y){
        BigDecimal b1 = new BigDecimal(Integer.toString(x));
        BigDecimal b2 = new BigDecimal(Integer.toString(y));
        return b1.multiply(b2).toString();
    }

    public String div(int x, int y){
        if(y==0)return "error";
        BigDecimal b1 = new BigDecimal(Integer.toString(x));
        BigDecimal b2 = new BigDecimal(Integer.toString(y));
        return b1.divide(b2,8,BigDecimal.ROUND_HALF_UP).toString();
    }

    public String sub(int x, int y){
        BigDecimal b1 = new BigDecimal(Integer.toString(x));
        BigDecimal b2 = new BigDecimal(Integer.toString(y));
        return b1.subtract(b2).toString();
    }

    public String pow(int x, int y){
        BigDecimal b1 = new BigDecimal(Integer.toString(x));
        return b1.pow(y).toString();
    }

}
