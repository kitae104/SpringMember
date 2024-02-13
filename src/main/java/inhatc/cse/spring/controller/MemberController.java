package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired   // --> 변경 필요!!
    private MemberService memberService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveForm(){
        System.out.println("======= 저장 폼으로 이동");
        return "member/saveForm";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute MemberDto memberDto){
        int saveResult = memberService.save(memberDto);
        if(saveResult > 0){
            return "loginForm";
        } else {
            return "member/saveForm";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        System.out.println("=========== 로그인 이동");
        return "/member/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session){
        boolean loginResult = memberService.login(memberDto);
        if(loginResult){
            session.setAttribute("loginEmail", memberDto.getMemberEmail());
            return "main";
        }else {
            return "/member/loginForm";
        }
    }

}
