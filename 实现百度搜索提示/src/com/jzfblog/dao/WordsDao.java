package com.jzfblog.dao;


import java.sql.SQLException;
import java.util.List;

import com.jzfblog.domain.WordBean;

public interface WordsDao {
	
	/**
	 * 用于查找关键字
	 * @param word
	 * @return
	 * @throws SQLException
	 */
	List<WordBean> findWords(String word) throws SQLException;
}
