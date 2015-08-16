package br.com.gazin.smartfood.mapper;

import org.apache.ibatis.annotations.Select;
import br.com.gazin.smartfood.domain.User;

public interface UserMapper {

	@Select("select id, user_name as username, password from users where id = #{id}")
	User getUser(Long id);
}
