package com.human.cafe;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.service.IF_boardService;
import com.human.util.FileDataUtil;
import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Controller
public class BbsController {
	@Inject
	private IF_boardService bsrv;
	@Inject
	private FileDataUtil FileDataUtil;
	
	@RequestMapping(value = "/wrAction", method = RequestMethod.POST)
	public String wrAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file) throws Exception {
		// 객체로 받을 때는 파라미터이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야한다 > 자동매핑
		System.out.println(bvo.getName() + "디버깅");
		String[] fileNames = FileDataUtil.fileUpload(file);
		bvo.setFiles(fileNames);
		//System.out.println(fileNames[0] + "이 디비에 저장될 파일명");
		/* System.out.println(file.getOriginalFilename()+"후 욕하고싶다"); */
		// filedatautil 객체의 fileupload 메서드를 호출 매개변수로 file를 넘긴다 <지정한 폴더로 첨부파일 복사>
		// 넘겨받은 파일명을 boardVo files변수에 저장
		//String[] fileName = FileDataUtil.fileUpload(file);
		bsrv.insertOne(bvo);
		// 디비작업 진행
		// model.addAttribute("sss", "hi" );
		return "redirect:/bbsList"; // view �̸�
	}
	@RequestMapping(value = "/bbsList", method = RequestMethod.GET)
	public String bbsList(Locale locale, Model model,@ModelAttribute("pagevo") PageVO pagevo) throws Exception {
		// 객체로 받을 때는 파라미터이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야한다 > 자동매핑
		if(pagevo.getPage()==null) {
			pagevo.setPage(1);
		}
		System.out.println("현제페이지"+pagevo.getPage());
		int totalpageCnt = bsrv.countBoard();
		System.out.println(totalpageCnt+"나와라~~~");
		pagevo.setTotalCount(totalpageCnt);
		List<BoardVO> list = bsrv.selectAll(pagevo);
		System.out.println(list.size()+"나와라~~~");
		
		for(int i=0 ; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		model.addAttribute("blist", list);
		model.addAttribute("pagevo", pagevo);
		return "bbs/bbsList"; // view �̸�
	}
	
	@RequestMapping(value = "/wrForm", method = RequestMethod.GET)
	public String wrAction1(Locale locale, Model model) {
		// 객체로 받을 때는 파라미터이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야한다 > 자동매핑
		return "bbs/wrForm"; // view �̸�
	}
	@RequestMapping(value = "/bbsView", method = RequestMethod.GET)
	public String BBsView(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		//DB작업
		bsrv.updatecnt(vno);
		BoardVO tampvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO",tampvo);
		List<String> attachList = bsrv.selectAttach(vno);
		model.addAttribute("attachList",attachList);
		
		return "bbs/view"; // view �̸�
	}
	//삭제
	@RequestMapping(value = "/bbsDel", method = RequestMethod.GET)
	public String BBsDel(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		//DB작업
		
		bsrv.boardDel(vno);
		return "redirect:bbsList"; // view �̸�
	}
	@RequestMapping(value = "/bbsmod", method = RequestMethod.GET)
	public String BBsmod(Locale locale, Model model, @RequestParam("vno") String vno) throws Exception{
		//DB작업
		BoardVO tampvo = bsrv.selectOne(vno);
		model.addAttribute("boardVO",tampvo);
		return "bbs/bbsmod"; // view �̸�
	}
	@RequestMapping(value = "/bbsmodAction", method = RequestMethod.POST)
	public String bbsmodAction(Locale locale, Model model, BoardVO bvo, MultipartFile[] file) throws Exception {
		// 객체로 받을 때는 파라미터이름과 객체의 변수 이름이 일치하고 getter, setter가 있어야한다 > 자동매핑
		// 디비작업 진행
		// model.addAttribute("sss", "hi" );
		bsrv.updateBoard(bvo);
		return "redirect:/bbsView?vno="+bvo.getNum(); // view �̸�
	}
}
