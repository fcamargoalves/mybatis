package net.compactasistemas.mybatis.mapper;

import net.compactasistemas.mybatis.model.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;

@Mapper
public interface UsersMapper {

    /* Método para listar todos */
    @Select("select * from users")
    List<Users> findAll();


    /* Método para inserir */
    @Insert("insert into users(name,salary) values(#{name},#{salary})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(Users users);
}
