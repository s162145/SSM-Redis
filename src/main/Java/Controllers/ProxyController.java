package Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.syl.ssm.designPattern.Pattern.*;

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
}
