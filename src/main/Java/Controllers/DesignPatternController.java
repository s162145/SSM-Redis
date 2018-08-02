package Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.syl.ssm.designPattern.Observable.JingDongObserver;
import pers.syl.ssm.designPattern.Observable.ProductList;
import pers.syl.ssm.designPattern.Observable.TaoBaoObserver;

@RestController
@RequestMapping("/api/RequestTest")
public class DesignPatternController {
    @RequestMapping("/Observer")
    public void Observer(){
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addObserver(taoBaoObserver);
        observable.addObserver(jingDongObserver);
        observable.addProduct("新增产品1");
    }
}
