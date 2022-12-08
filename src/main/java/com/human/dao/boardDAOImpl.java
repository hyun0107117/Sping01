package com.human.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

@Repository // dao 단입을 알려준다
public class boardDAOImpl implements IF_boardDAO {
	// spring의 dao 와 mybatis sqlsession을 연결하는 객체

	private static String mampperQuery = "com.human.dao.IF_boardDAO";// 메핑 인터페이스 경로설정

	// Mybatis의 sqlsesstion객체가 필요하다
	@Inject // 컨테이너에서 가져와야한다, 컨테이너에서 자료형과 맞는 객체의 주소를 주입해 준다.
	private SqlSession sqlSession; // sqlsession타입의 객체는 스프링 컨테이너에 있다.
									// 여기서 이 객체가 필요하다 그런데 컨테이너에서 가져와야한다. 스피링은DI개념

	@Override
	public void insertOne(BoardVO boardvo) throws Exception {
		sqlSession.insert(mampperQuery + ".insertOne", boardvo);// 쿼리를 매핑 및 실행한다
		// <insert>//매핑정보 //id //parameter
	}

	@Override
	public List<BoardVO> selectAll(PageVO pagevo) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mampperQuery+".selectAll",pagevo);
	}
	
	@Override
	public int countBoard() throws Exception{
		return sqlSession.selectOne(mampperQuery+".countBoard");
	}

	@Override
	public void insertAttach(String filename) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(mampperQuery+".board_attach",filename);
		
	}

	@Override
	public BoardVO selectOne(String vno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(mampperQuery+".selectOne",vno);
	}

	@Override
	public List<String> selectAttach(String vno) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(mampperQuery+".selectAttach",vno);
	}

	@Override
	public void updateCnt(String vno) throws Exception {
		sqlSession.update(mampperQuery+".cntplus",vno);
		
	}

	@Override
	public void boardDel(String vno) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(mampperQuery+".boardDel",vno);
	}

	@Override
	public void updateBoard(BoardVO boardvo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(mampperQuery+".boardUpdate", boardvo);
	}
}
