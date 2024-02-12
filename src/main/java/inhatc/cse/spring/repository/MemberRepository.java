package inhatc.cse.spring.repository;

import inhatc.cse.spring.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final SqlSessionTemplate sql;
    public int save(MemberDto memberDto) {
        System.out.println("memberDto : " + memberDto);
        return sql.insert("Member.save", memberDto);
    }
}
