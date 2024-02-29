package inhatc.cse.spring.service;

import inhatc.cse.spring.dto.CommentDto;
import inhatc.cse.spring.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public void save(CommentDto commentDto) {
        commentRepository.save(commentDto);
    }

    public List<CommentDto> findAll(Long boardId) {
        return commentRepository.findAll(boardId);
    }
}
