package Controllers;

import Entity.SeeUser;
import Service.RedisBaiseTakes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("test")
public class RedisTest {
    @Resource(name="seeUserRedisTakes")
    private RedisBaiseTakes seeUserRedisTakes;

    @RequestMapping("/hello.do")
    public ModelAndView hello(){
        ModelAndView mv = new ModelAndView();
        System.out.println("hello see");
        seeUserRedisTakes.add("hello1","zxm");
        mv.setViewName("hello");
        return mv;
    }

}
