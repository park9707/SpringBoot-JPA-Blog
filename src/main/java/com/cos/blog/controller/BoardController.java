package com.cos.blog.controller;

import com.cos.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping({"","/"})
    public String index(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC)Pageable pageable){
        model.addAttribute("boards",boardService.글목록(pageable));
        return "index"; //Controller는 리턴할때 viewResolver가 작동하는데 그 때 해당 리턴페이지로 모델의 정보를 들고 이동
    }

    @GetMapping("/board/{id}")
    public String findById(@PathVariable int id,Model model){
        model.addAttribute("board",boardService.글상세보기(id));
        return "board/detail";
    }

    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model){
        model.addAttribute("board",boardService.글상세보기(id));
        return "board/updateForm";
    }

    @GetMapping("/board/saveForm")
    public String saveForm(){
        return "board/saveForm";
    }
}
