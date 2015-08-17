package br.com.gazin.smartfood.mapper;

import org.apache.ibatis.annotations.Select;
import br.com.gazin.smartfood.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

public interface UserMapper {
	@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "username", column = "user_name"),
		@Result(property = "password", column = "password") })

	@Select("select * from users where id = #{id}")
	User getUser(Long id);
}
