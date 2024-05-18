package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberAPIController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDto memberDto){		// 동적 반환을 위해 ? 사용
        System.out.println("=========== 로그인 API 호출" + memberDto);
        boolean loginResult = memberService.login(memberDto);
        System.out.println("=========== 로그인 결과 : " + loginResult);
        return new ResponseEntity<>(loginResult, HttpStatus.OK);			// 200
    }

    @PostMapping("/membersave")
    public ResponseEntity<?> save(@RequestBody MemberDto memberDto){		// 동적 반환을 위해 ? 사용
        System.out.println("=========== 로그인 API 호출(SAVE)" + memberDto);
        int saveResult = memberService.save(memberDto);     // 회원 가입 처리
        System.out.println("=========== 회원 가입 결과 : " + saveResult);
        return new ResponseEntity<>(saveResult, HttpStatus.OK);			// 200
    }
}
