package pers.syl.ssm.designPattern.Proxy;

public class HelloWorldImpl implements HelloWorld{
    @Override
    public void sayHelloWorld(){
        System.out.println("Hello World");
    }

    @Override
    public void sayWang(){
        System.out.println("wang wang, ba zha hei");
    }
}
