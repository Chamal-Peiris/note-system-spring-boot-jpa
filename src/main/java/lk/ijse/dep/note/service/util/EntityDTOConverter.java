package lk.ijse.dep.note.service.util;

import lk.ijse.dep.note.dto.UserDTO;
import lk.ijse.dep.note.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOConverter {
    @Autowired
    private ModelMapper mapper;

    public  EntityDTOConverter(ModelMapper mapper){
        this.mapper=mapper;
    }

    public User getUserEntity(UserDTO user){
        return mapper.map(user,User.class);
    }
    public UserDTO getUserDTO(User user){
        return mapper.map(user,UserDTO.class);
    }
}
