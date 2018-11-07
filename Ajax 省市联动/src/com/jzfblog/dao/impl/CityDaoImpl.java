package com.jzfblog.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jzfblog.dao.CityDao;
import com.jzfblog.domain.CityBean;
import com.jzfblog.utils.JDBCUtil;

public class CityDaoImpl implements CityDao{

	/**
	 * 查询某省份下的所有城市
	 * @throws SQLException 
	 */
	public List<CityBean> findCity(int pid) throws SQLException {
		
		QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from city where pid = ?";
		return queryRunner.query(sql, 
				new BeanListHandler<CityBean>(CityBean.class),
				pid);
	}
	
	
}
