package inhatc.cse.spring.repository;

import inhatc.cse.spring.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final SqlSessionTemplate sql;

    public void save(CommentDto commentDto) {
        sql.insert("Comment.save", commentDto);
    }

    public List<CommentDto> findAll(Long boardId) {
        return sql.selectList("Comment.findAll", boardId);
    }
}
