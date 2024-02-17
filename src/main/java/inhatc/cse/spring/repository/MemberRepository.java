package inhatc.cse.spring.repository;

import inhatc.cse.spring.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;
    public int save(MemberDto memberDto) {
        System.out.println("memberDto : " + memberDto);
        return sql.insert("Member.save", memberDto);
    }

    public MemberDto login(MemberDto memberDto) {
        return sql.selectOne("Member.login", memberDto);    // 조회 결과 1개 반환
    }

    public List<MemberDto> findAll() {
        return sql.selectList("Member.findAll");
    }

    public MemberDto findById(Long id) {
        return sql.selectOne("Member.findById", id);
    }

    public void delete(Long id) {
        sql.delete("Member.delete", id);
    }

    public MemberDto findByMemberEmail(String loginEmail) {
        return sql.selectOne("Member.findByMemberEmail", loginEmail);
    }

    public int update(MemberDto memberDto) {
        return sql.update("Member.update", memberDto);
    }

}
