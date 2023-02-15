package alin.licenta.be.services;

import alin.licenta.be.dto.UserDTO;
import alin.licenta.be.entities.User;
import alin.licenta.be.mappers.UserMapper;
import alin.licenta.be.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User create(UserDTO userDTO) {
        return userRepository.save(userMapper.dtoToEntity(userDTO));
    }

    public User update(int id, UserDTO userDTO) {
        userDTO.setId(id);
        return userRepository.save(userMapper.dtoToEntity(userDTO));
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User findEntityById(int id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    public UserDTO findDTOById(int id) {
        return userMapper.entityToDto(findEntityById(id));
    }

    public List<UserDTO> findAll() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::entityToDto)
                .toList();
    }
}
