package hello.hellospring.controller;

import hello.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","hello!!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("nname",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //응답바디부분에 직접 데이터를 넣어주겠다는 의미이다.
    public String helloString(@RequestParam("name") String name,Model model)
    {
        return "hello "+name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody // 이게 없으면 view로 보내지 않음
    public Hello HelloApi(@RequestParam String name,Model model){
        Hello hello = new Hello(); //ctrl shift enter하면 엔터를 자동으로 쳐줌
        hello.setName(name);
        hello.setAge(12);
        return hello;
    }

    public class Hello{
        private String name;
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        //alt+insert
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
