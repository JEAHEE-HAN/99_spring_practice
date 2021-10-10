package com.spring.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.practice.dto.BoardDto;
import com.spring.practice.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.GET)
	public String boardWrite() throws Exception {
		return "board/bWrite";
	}
	
	@RequestMapping(value="/boardWrite" , method=RequestMethod.POST)
	public String boardWrite(BoardDto bdto) throws Exception {
		boardService.insertBoard(bdto);
		return "board/bWrite";
	}
	
	@RequestMapping(value="/boardList" , method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		model.addAttribute("boardList" , boardService.getBoardList());
		return "board/bList";
	}
	@RequestMapping(value="boardInfo", method=RequestMethod.GET)
	public String boardInfo(@RequestParam("num") int num , Model model) throws Exception { 
							// Integer.parseInt(request.getParameter("num"));
		/*
		 * @RequestParam("매개변수명") 변수타입 변수명
		 * */
		
		
		model.addAttribute("bdto" , boardService.getOneBoard(num));
		
		return "board/bInfo";
	}
	
	@RequestMapping(value="/boardUpdate", method=RequestMethod.GET)
	public String boardUpdate(@RequestParam("num") int num , Model model) throws Exception{
		
		model.addAttribute("bdto" , boardService.getOneBoard(num));
		return "board/bUpdate";
	}
	
	@RequestMapping(value="/boardUpdate" , method=RequestMethod.POST)
	public String boardUpdate(BoardDto bdto , Model model) throws Exception {
		
		if(boardService.updateBoard(bdto)) model.addAttribute("success" , true);
		else							   model.addAttribute("success" , false);
		
		return "board/bUpdatePro";
	}
	
	@RequestMapping(value="/boardDelete" , method=RequestMethod.GET)
	public String boardDelete(@RequestParam("num") int num , Model model) throws Exception {
		model.addAttribute("bdto" , boardService.getOneBoard(num));
		return "board/bDelete";
	}
	
   @RequestMapping(value="/boardDelete" , method=RequestMethod.POST)
   public String boardDelete(BoardDto bdto , Model model) throws Exception {
      if(boardService.deleteBoard(bdto))   model.addAttribute("success" , true);
      else                         model.addAttribute("success" , false);
      
      return "board/bDeletePro";
   }
}
