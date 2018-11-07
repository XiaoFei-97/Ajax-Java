package com.jzfblog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jzfblog.dao.WordsDao;
import com.jzfblog.domain.WordBean;
import com.jzfblog.utils.JDBCUtil;

/**
 * WordsDao的逻辑实现
 * @author 蒋振飞
 *
 */
public class WordsDaoImpl implements WordsDao{

	/**
	 * 查找关键字
	 */
	public List<WordBean> findWords(String word) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
		
		String sql = "select * from words where word like ?  limit ?";
		return queryRunner.query(sql, new BeanListHandler<WordBean>(WordBean.class) , word+"%" , 5);
	}
	
}
