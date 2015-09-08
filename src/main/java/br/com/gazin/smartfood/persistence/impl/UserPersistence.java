package br.com.gazin.smartfood.persistence.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.gazin.smartfood.domain.User;
import br.com.gazin.smartfood.mapper.UserMapper;

/**
 * @author luangazin
 *
 */
@Repository("userPersistence")
public class UserPersistence implements UserMapper {

	private SqlSession sqlSession;

	@Autowired
	public UserPersistence(SqlSessionFactory factory) {
		sqlSession = factory.openSession();
	}

	@Override
	public User getUser(Long id) {
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getUser(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
