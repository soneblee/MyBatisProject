package com.example.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {

    @Autowired
    BoardServiceImpl boardServiceImpl;

    @RequestMapping( "/board/list")
    public String boardList(Model model) {
        model.addAttribute("list", boardServiceImpl.getBoardList());
        return "list";
    }

    @RequestMapping(value = "board/addpostform", method = RequestMethod.GET)
    public String addPost() {
        return "addpostform";
    }

    @RequestMapping(value = "board/addok", method = RequestMethod.POST)
    public String addPostok(BoardVO vo) {
        int i = boardServiceImpl.insertBoard(vo);
        if(i == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "board/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardServiceImpl.getBoard(id);
        model.addAttribute("u", boardVO);
        return "editform";
    }

    @RequestMapping(value = "board/editok", method = RequestMethod.POST)
    public String editPostok(BoardVO vo) {
        int i = boardServiceImpl.updateBoard(vo);
        if(i == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "/board/deleteok/{id}", method = RequestMethod.GET)
    public  String deletePostok(@PathVariable("id") int id) {
        if(boardServiceImpl.deleteBoard(id) == 0)
            System.out.println("데이터 삭제 실패");
        else
            System.out.println("데이터 삭제 성공!!!");
        return "redirect:../list";
    }

    @RequestMapping(value = "board/view/{id}", method = RequestMethod.GET)
    public String view(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardServiceImpl.getBoard(id);
        model.addAttribute("list", boardVO);
        return "view";
    }

}