package hello.hellospring.controller;


import hello.hellospring.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    //아래와 같이 서비스를 불러와도 되지만, 매번 불러와야? 하기때문에 불편하다
    //private final MemberSerivce memberSerivce = new MemberSerivce();
    private final MemberSerivce memberSerivce;
    // @Autowired //오토와이어드를 사용하면 컨트롤러를 호출할때마다 스프링에서 자동으로 가져옴 자동으로 연결시켜주는 느낌
    @Autowired
    public MemberController(MemberSerivce memberSerivce)
    {

        this.memberSerivce=memberSerivce;
    }
    @GetMapping("/members/new")
    public String createForm(){
        return "mebmers/createMemberForm";
    }

}
