package Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.syl.ssm.designPattern.Factory.Factory;
import pers.syl.ssm.designPattern.Factory.IDCardFactory;
import pers.syl.ssm.designPattern.Factory.Product;
import pers.syl.ssm.designPattern.Observable.JingDongObserver;
import pers.syl.ssm.designPattern.Observable.ProductList;
import pers.syl.ssm.designPattern.Observable.TaoBaoObserver;

@RestController
@RequestMapping("/api/DesignPattern")
public class DesignPatternController {
    @RequestMapping("/ObserverTest")
    public void ObserverTest(){
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addObserver(taoBaoObserver);
        observable.addObserver(jingDongObserver);
        observable.addProduct("新增产品1");
    }

    @RequestMapping("/FactoryTest")
    public void FactoryTest(){
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }

    @RequestMapping("/AbstractFactoryTest")
    public void AbstractFactoryTest(){
        pers.syl.ssm.designPattern.AbstractFactory.Factory factory = pers.syl.ssm.designPattern.AbstractFactory.Factory.getFactory("");
    }

}
