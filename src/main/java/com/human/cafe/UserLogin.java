package com.human.cafe;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserLogin {

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpSession session,
//			@RequestParam("id") String id,
//			@RequestParam("pass") String pass) {
//		System.out.println("불러오냐"); // 로그인 절차
//		// 1. 파라미터 받는다 2. 뭐리 실행후 결과값에 따라 판다. 서비스단이 필요 // 현재는 테스트용으로 설정
//		if (id.equals("ttt")) { // 쿼리 실행 후 아이와 패스워드가 정상적인 경우 리턴받는 것으로 수정 //로그인 성공인경우
//			session.setAttribute("login", id);// 세션처리
//			session.setAttribute("grade", "vip");// 처리하고 싶은 변수를 선택하여 등록, 객체도 가능
//			System.out.println("로그인성공");
//		} else { // 로그인 실패인경우 } // <--------여기까지가 테스트용 나중에디비 연동시켜야함
//			System.out.println("로그인 공사중");
//		}
//		return "home";
//
//	}

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpSession session, @RequestParam("id") String id, @RequestParam("pass") String pass) {
		// 로그인 절차
		// 1. 파라미터 받는다. 2.쿼리 실행 후 결과값에 따라 판단.. 서비스단이 필요

		String message = "";
		if (id.equals("ttt")) { // 쿼리 실행 후 아이디와 패스워드가 정상적인 경우 리턴받는 것으로 수정
			// 로그인 성공인 경우
			if (session.getAttribute("login") != null) {
				session.removeAttribute("login"); // 일종의 초기화 한번 더 청소하고 가겠다.

			}
			message = "<script>alert('로그인 성공aaa');location.href='/cafe';</script>";
			session.setAttribute("login", id); // 세션처리
			session.setAttribute("grade", "vip"); // 처리하고 싶은 변수를 선택하여 등록, 객체도 가능
		} else {

			message = "<script>alert('로그인 실패  bbbb');location.href='/cafe';</script>";

		}
		// <--- 여기까지가 테스트용 나중에 DB연동 시켜야 한다.
		return message;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:/";

	}
}
