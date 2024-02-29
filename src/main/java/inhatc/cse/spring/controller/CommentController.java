package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.CommentDto;
import inhatc.cse.spring.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save")
    public @ResponseBody List<CommentDto> save(@ModelAttribute CommentDto commentDto){
        System.out.println("commentDto : " + commentDto);
        commentService.save(commentDto);

        // 해당 게시글에 작성된 댓글 리스트
        List<CommentDto> list = commentService.findAll(commentDto.getBoardId());
        System.out.println("List : " + list);
        return list;
    }
}
