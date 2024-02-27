package inhatc.cse.spring.controller;

import inhatc.cse.spring.dto.BoardDto;
import inhatc.cse.spring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "board/save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDto boardDto){
        int saveResult = boardService.save(boardDto);
        if(saveResult > 0){
            return "redirect:/board/list";
        } else {
            return "board/save";
        }
    }

    @GetMapping("/list")
    public String findAll(Model model){
        List<BoardDto> boardDtoList = boardService.findAll();
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }

    @GetMapping("/detail")
    public String findById(@RequestParam("id") Long id, Model model){
        boardService.updateHits(id);    // 조회수 증가
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "board/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){
        boardService.delete(id);
        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        BoardDto boardDto = boardService.findById(id);
        model.addAttribute("board", boardDto);
        return "board/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDto boardDto, Model model){
        boardService.update(boardDto);
        BoardDto dto = boardService.findById(boardDto.getId());
        model.addAttribute("board", dto);
        return "board/detail";
    }

    // /board/paging?page=1
    @GetMapping("/paging")
    public String paging(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                         Model model){
        System.out.println("page = " + page);
        // 해당 페이지에 보여줄 글 목록
        List<BoardDto> boardDtoList = boardService.pagingList(page);
        model.addAttribute("boardList", boardDtoList);
        return "board/list";
    }
}
