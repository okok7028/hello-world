package controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@RequestMapping("/boardList.do")
	public ModelAndView boardList(@RequestParam(value="p", defaultValue="1")int page) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardPage", service.makeBoardPage(page));
		mv.setViewName("boardview/boardList");
		return mv;
	}
	
	@RequestMapping("/writeForm.do")
	public ModelAndView writerForm(@RequestParam(value="n", defaultValue="0")int boardNum, HttpSession session) {
		ModelAndView mv = new ModelAndView("boardview/writeForm");
//		if(session.getAttribute("loginId") != null) {
		mv.addObject("writer", service.getNick((String)session.getAttribute("loginId")));
//		}
		if((Integer)boardNum==0) {
		mv.addObject("num", 0);
		mv.addObject("boardRef", 1);
		mv.addObject("replySeq", 0);
		mv.addObject("replyLevel", 0);
		}else {
			BoardVO vo = service.readWithoutCount(boardNum);
			mv.addObject("num", boardNum);
			mv.addObject("boardRef", vo.getBoardRef());
			mv.addObject("replySeq", vo.getReplySeq());
			mv.addObject("replyLevel", vo.getReplyLevel());
		}
		return mv;
	}
	
	@RequestMapping(value="/writeProc.do", method=RequestMethod.POST)
	@ResponseBody
	public void writeProc(BoardVO board, int num, HttpServletResponse response) {

		int insertedNum = service.write(board, num);
		
		try {
			response.sendRedirect("writeResult.do?boardNum="+insertedNum);
		} catch (IOException e) {
			System.out.println("글쓰기 실패");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/writeResult.do")
	public ModelAndView writeResult(int boardNum) {
		ModelAndView mv = new ModelAndView("boardview/writeResult");
		mv.addObject("resultBoard", service.readWithoutCount(boardNum));
		return mv;
	}
	
	@RequestMapping(value="/read.do", method=RequestMethod.GET)
	@ResponseBody
	public void read(@RequestParam("n")int boardNum, 
			@RequestParam(value="p")int currentPage, HttpServletResponse response) {
		
		BoardVO vo = service.read(boardNum);
		int insertedNum = vo.getBoardNum();
		
		try {
			response.sendRedirect("readResult.do?n="+insertedNum+
					"&p="+currentPage);
		} catch (IOException e) {
			System.out.println("글읽기 실패");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/readResult.do")
	public ModelAndView readResult(@RequestParam("n")int boardNum, @RequestParam("p")int currentPage) {
		ModelAndView mv = new ModelAndView("boardview/read");
		mv.addObject("board", service.readWithoutCount(boardNum));
		mv.addObject("p", currentPage);
		return mv;
	}
}
