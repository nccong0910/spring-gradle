package com.example.springgradle.common.errors;

public class Exeptions extends Exception{
    private String detail;

    public Exeptions(String code, String detail){
        super(code);
        this.detail = detail;
    }
}
