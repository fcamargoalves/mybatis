package net.compactasistemas.mybatis.resource;


import net.compactasistemas.mybatis.mapper.UsersMapper;
import net.compactasistemas.mybatis.model.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersMapper usersMapper;

    public UsersResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    /* Método lista todos */
    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }

    /* Método para salvar */
    @GetMapping("/update")
    private List<Users> update(){
        Users users = new Users();
        users.setName("maria");
        users.setSalary(5000L);

        usersMapper.insert(users);

        return usersMapper.findAll();

    }


}
