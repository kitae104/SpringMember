package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired   // --> 변경 필요!!
    private MemberService memberService;

    // 1. value 사용형식 체크
    // 2. 메소드 사용 방법 체크
    // 3. MVC 패턴 확인
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String saveForm() {
        return "member/save";       // 회원 가입 페이지로 이동
    }

    // 1. GET vs. POST 방식 체크
    // 2. @ModelAttribute 사용법 체크 --> 객체 전달
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute MemberDto memberDto) {
        int saveResult = memberService.save(memberDto);     // 회원 가입 처리
        if (saveResult > 0) {        // 저장된 결과가 0보다 큰 경우 회원 가입 성공
            return "member/login";   // 로그인 페이지로 이동
        } else {
            return "member/save";     // 저장된 결과가 0인 경우 회원 가입 실패 --> 회원 가입 페이지로 이동
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        //System.out.println("=========== 로그인 이동");
        return "member/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDto memberDto, HttpSession session) {
        boolean loginResult = memberService.login(memberDto);
        if (loginResult) {
            session.setAttribute("loginEmail", memberDto.getMemberEmail());
            return "main";
        } else {
            return "member/login";
        }
    }

    @GetMapping("/list")
    public String listForm(Model model) {
        //System.out.println("=========== 사용자 리스트로 이동");
        List<MemberDto> memberDtoList = memberService.findAll();
        System.out.println("memberDtoList : " + memberDtoList);
        model.addAttribute("memberList", memberDtoList);
        return "/member/list";
    }

    // /member/detail?id=1 형태
    @GetMapping("/detail")
    public String detailForm(@RequestParam("id") Long id, Model model) {
        MemberDto memberDto = memberService.findById(id);
        model.addAttribute("member", memberDto);
        return "member/detail";
    }

    // 링크 방식을 사용하기 때문에 get 방식으로 처리
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id, Model model) {
        memberService.delete(id);
        return "redirect:/member/list";
    }

    @GetMapping("/update")
    public String updateForm(HttpSession session, Model model) {
        String loginEmail = (String) session.getAttribute("loginEmail");
        System.out.println("============ 로그인 이메일 : " + loginEmail);
        MemberDto memberDto = memberService.findByMemberEmail(loginEmail);
        System.out.println("============ memberDto : " + memberDto);
        model.addAttribute("member", memberDto);
        return "member/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute MemberDto memberDto) {
        boolean result = memberService.update(memberDto);
        if (result) {
            return "redirect:/member/detail?id=" + memberDto.getId();
        } else {
            return "index";
        }
    }

    @PostMapping("/email-check")  // 객체 전달을 위해서는 매개변수 전달시에 @ResponseBody 사용
    public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
        //System.out.println("====== 전달된 이메일 : " + memberEmail);
        String result = memberService.emailCheck(memberEmail);
        return result;
    }
}
