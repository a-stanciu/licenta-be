package alin.licenta.be.services;

import alin.licenta.be.dto.UserDTO;
import alin.licenta.be.entities.AuthenticationRequest;
import alin.licenta.be.entities.User;
import alin.licenta.be.mappers.UserMapper;
import alin.licenta.be.repositories.UserRepository;
import alin.licenta.be.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final JwtUtil jwtTokenUtil;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, JwtUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.jwtTokenUtil = jwtTokenUtil;
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

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        try {
            user = userRepository.findByEmail(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public String authenticate(AuthenticationRequest authenticationRequest) {
        final User userDetails = loadUserByUsername(authenticationRequest.getUsername());

        return jwtTokenUtil.generateToken(userDetails);
    }

    public int getUserId(User user) {
        return user.getId();
    }

    public User getUserById(int id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }
}
