package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
    @GetMapping("/members/new")  //url을 치는것은 보통 getmapping 이라고 한다.
    public String createForm(){
        return "/createMemberForm";
    }
    @PostMapping("/members/new") //MemberForm 에 어떻게 들어오는것 일까?
    public String create(MemberForm form) //스프링이 자동으로 MemberForm 클래스 안에 setName함수를 진행시켜 name 값을 넣어준다
                                          //그래서 formData의 name이랑 클래스의 변수랑 type이 같아야하는것!
    {
        Member member = new Member();
        member.setName(form.getName()); //들어간 변수 멤버에 저장

        memberSerivce.join(member);

        return "redirect:/";  //홈화면으로 보내는것?
    }
    @GetMapping("/members")
    public String list(Model model)
    {
        List<Member> members = memberSerivce.findMember();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
