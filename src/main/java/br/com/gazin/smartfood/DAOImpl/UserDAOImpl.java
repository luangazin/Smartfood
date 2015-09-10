package br.com.gazin.smartfood.DAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.gazin.smartfood.DAO.UserDAO;
import br.com.gazin.smartfood.domain.User;
import br.com.gazin.smartfood.mapper.UserMapper;

/**
 * @author luangazin
 *
 */
@Component("UserDAOImpl")
public class UserDAOImpl implements UserDAO {
	@Autowired
	@Qualifier("userPersistence")
	public UserMapper userMapper;

	public User getUser(Long id) {
		return userMapper.getUser(id);
	}

}
