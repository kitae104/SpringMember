package inhatc.cse.spring.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageDto {
    private int page;           // 현재 페이지
    private int maxPage;        // 최대 페이지
    private int startPage;      // 시작 페이지
    private int endPage;        // 끝 페이지
}
