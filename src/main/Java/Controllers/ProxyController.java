package Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.syl.ssm.designPattern.Proxy.*;

@RestController
@RequestMapping("/api/Proxy")
public class ProxyController {
    @RequestMapping("/JDK")
    public void testJdkProxy(){
        JdkProxyExample jdk = new JdkProxyExample();
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImpl());
        proxy.sayHelloWorld();
        proxy.sayWang();
    }

    @RequestMapping("/CGLIB")
    public void testCGLIBProxy(){
        CglibProxyExample cpe = new CglibProxyExample();
        HelloWorldNoInterface obj = (HelloWorldNoInterface)cpe.getProxy(HelloWorldNoInterface.class);
        obj.sayHelloWorld();
    }

    @RequestMapping("/MyInterceptor")
    public void myInterceptor(){
        HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "pers.syl.ssm.designPattern.Proxy.MyInterceptor");
        proxy.sayHelloWorld();
    }

    @RequestMapping("/ChainOfResponsibility")
    public void ChainOfResponsibility(){
        HelloWorld proxy1 = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImpl(),
                "pers.syl.ssm.designPattern.ChainOfResponsibility.Interceptor1");
        HelloWorld proxy2 = (HelloWorld)InterceptorJdkProxy.bind(proxy1,
                "pers.syl.ssm.designPattern.ChainOfResponsibility.Interceptor2");
        HelloWorld proxy3 = (HelloWorld)InterceptorJdkProxy.bind(proxy2,
                "pers.syl.ssm.designPattern.ChainOfResponsibility.Interceptor3");
        proxy3.sayHelloWorld();
    }
}
