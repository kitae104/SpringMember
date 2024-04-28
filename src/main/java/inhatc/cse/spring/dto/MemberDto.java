package inhatc.cse.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 1. lombok 사용법 체크
// 2. @Data vs @Getter @Setter @ToString 차이점 체크
// 3. Data Transfer Object (DTO) 확인 vs Entity 차이
@Getter
@Setter
@ToString
public class MemberDto {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private int memberAge;
    private String memberMobile;
}
