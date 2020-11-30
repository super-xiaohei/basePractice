package suncaper.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import suncaper.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zyq
 * @date 2020/11/5 - 17:47
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String hello(HttpServletRequest request, @PathVariable("id") Integer ID){
        System.out.println(ID);
        return "hello"; //等价于转发
    }

    @GetMapping("/test")
        public void test1(@RequestParam(value = "id") Integer id){
        System.out.println(id);
    }

    @GetMapping("/login")
    public void test2(User user){
        System.out.println(user.getUsername() + "------>" + user.getPassword());

    }

    @GetMapping("/loginCopy")
    public String test3(User user, Model model){
        model.addAttribute("aa","bb");
        return "hello";
    }

    //如果要返回json数据（{x=a,y=b}），需要注解
    @ResponseBody
    @RequestMapping("/ajax")
    public Map ajax(){
        Map<String,String > map = new HashMap<>();
        map.put("code","200");
        System.out.println("ajax来了...");
        return map;
    }
}
