package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.BoardDto;
import inhatc.cse.spring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

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
}
