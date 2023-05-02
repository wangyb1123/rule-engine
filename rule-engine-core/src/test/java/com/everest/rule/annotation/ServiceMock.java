package com.everest.rule.annotation;

import com.everest.rule.parser.TradeMock;

@RuleService(name = "serviceMock")
public class ServiceMock {

    public String serviceMethod1(String user){
        return user+"_serviceMethod1";
    }

    public String serviceMethod1(int number){
        return String.valueOf(number);
    }

    public String functionCallWithObject(TradeMock tradeMock, String user){
        return user + "_functionCallWithObject_TradeMock_" + tradeMock.getId();
    }

    public String toUpperCase(String test){
        return test.toUpperCase();
    }

    public long max(long i, long j){
        return Math.max(i, j);
    }

    public String functionCallTest(String city, String country){
        return country;
    }
}
