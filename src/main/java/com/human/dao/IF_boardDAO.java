package com.human.dao;

import java.util.List;

import com.human.vo.BoardVO;
import com.human.vo.PageVO;

public interface IF_boardDAO {
	public void insertOne(BoardVO boardvo) throws Exception;
	public List<BoardVO> selectAll(PageVO pagevo) throws Exception;
	public int countBoard() throws Exception;
	public void insertAttach(String filename) throws Exception;
	public BoardVO selectOne(String vno) throws Exception;
	public List<String> selectAttach(String vno) throws Exception;
	public void updateCnt(String vno) throws Exception;
	public void boardDel(String vno) throws Exception;
	public void updateBoard(BoardVO boardvo) throws Exception;
	
}
