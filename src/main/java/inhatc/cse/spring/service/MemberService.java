package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.MemberDto;
import inhatc.cse.spring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor  // 생성자 주입 방식
public class MemberService {

    private final MemberRepository memberRepository;

    public int save(MemberDto memberDto) {
        return memberRepository.save(memberDto);
    }

    public boolean login(MemberDto memberDto) {
        MemberDto loginMember = memberRepository.login(memberDto);
        if(loginMember != null){
            return true;
        } else {
            return false;
        }
    }

    public List<MemberDto> findAll() {
        return memberRepository.findAll();
    }

    public MemberDto findById(Long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.delete(id);
    }

    public MemberDto findByMemberEmail(String loginEmail) {
        return memberRepository.findByMemberEmail(loginEmail);
    }

    public boolean update(MemberDto memberDto) {
        int result = memberRepository.update(memberDto);
        if(result > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String emailCheck(String memberEmail) {
        MemberDto memberDto = memberRepository.findByMemberEmail(memberEmail);
        if(memberDto == null){
            return "YES";
        } else {
            return "NO";
        }
    }
}
