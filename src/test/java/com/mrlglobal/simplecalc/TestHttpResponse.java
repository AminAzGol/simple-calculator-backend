package com.mrlglobal.simplecalc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Array;

class CalcTestCase {
    private double a;
    private double b;
    private String op;
    double expectedResult;
    CalcTestCase(double a, double b, String op, double exp){
        this.a = a;
        this.b = b;
        this.op = op;
        this.expectedResult = exp;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
}

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestHttpResponse {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHelloWorld(){
        Assertions.assertEquals("Hello World!",
                testRestTemplate.getForObject("http://localhost:"+port+"/",
                        String.class));
    }

    @Test
    public void testCalculator(){
        CalcTestCase[] testCase = new CalcTestCase[5];
        testCase[0] = new CalcTestCase(10, 12, "+", 22);
        testCase[1] = new CalcTestCase(10, 12, "-", -2);
        testCase[2] = new CalcTestCase(10, 12, "*", 120);
        testCase[3] = new CalcTestCase(10, 2, "/", 5);
        testCase[4] = new CalcTestCase(-10, -2, "/", 5);

        for(int i=0; i < testCase.length; i++){
            CalculatorOperation result = testRestTemplate.postForEntity("http://localhost:"+port+"/calc",
                    testCase[i],
                    CalculatorOperation.class).getBody();
            Assertions.assertEquals(testCase[i].expectedResult, result.getResult());
        }
    }
}
