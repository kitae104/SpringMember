package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.BoardDto;
import inhatc.cse.spring.dto.PageDto;
import inhatc.cse.spring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private int pageLimit = 3;      // 한 페이지에 보여줄 게시글 수
    private int blockLimit = 3;     // 페이지 네비게이션에 보여줄 페이지 수

    public int save(BoardDto boardDto) {
        return boardRepository.save(boardDto);
    }

    public List<BoardDto> findAll() {
        return boardRepository.findAll();
    }

    public BoardDto findById(Long id) {
        return boardRepository.findById(id);
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }

    public void update(BoardDto boardDto) {
        boardRepository.update(boardDto);
    }

    public List<BoardDto> pagingList(int page) {

        // 1page -> 0, 2page -> 3, 3page -> 6
        int pageStart = (page - 1) * pageLimit;

        //Map<String, Integer> pagingParams = Map.of("start", pageStart, "limit", pageLimit);
        Map<String, Integer> pagingParams = new HashMap<>();
        pagingParams.put("start", pageStart);
        pagingParams.put("limit", pageLimit);

        List<BoardDto> pagingList = boardRepository.pagingList(pagingParams);
        return pagingList;
    }

    public PageDto pagingParam(int page) {
        // 전체 게시글 수
        int boardCount = boardRepository.boardCount();

        // 전체 페이지 갯수 계산 (10/3 = 3.3333 -> 4개 필요)
        int maxPage = (int) Math.ceil((double) boardCount / pageLimit);

        // 시작 페이지 번호(1, 4, 7, 10, ~)
        int startPage = (((int)(Math.ceil((double) page / blockLimit))) -1) * blockLimit + 1;

        // 끝 페이지 번호(3, 6, 9, 12, ~)
        int endPage = startPage + blockLimit -1;

        if (endPage > maxPage) {        // 최대 페이지(4)가 끝 페이지(6)보다 작은 경우
            endPage = maxPage;          // -> 최대 페이지로 설정
        }
        PageDto pageDto = new PageDto();
        pageDto.setPage(page);
        pageDto.setMaxPage(maxPage);
        pageDto.setStartPage(startPage);
        pageDto.setEndPage(endPage);
        return pageDto;
    }
}
