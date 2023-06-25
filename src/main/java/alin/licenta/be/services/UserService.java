package alin.licenta.be.services;

import alin.licenta.be.dto.UserDTO;
import alin.licenta.be.entities.AuthenticationRequest;
import alin.licenta.be.entities.Cart;
import alin.licenta.be.entities.OrderStatus;
import alin.licenta.be.entities.User;
import alin.licenta.be.mappers.UserMapper;
import alin.licenta.be.repositories.CartRepository;
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

    private final CartRepository cartRepository;

    private final UserMapper userMapper;

    private final JwtUtil jwtTokenUtil;

    @Autowired
    public UserService(UserRepository userRepository, CartRepository cartRepository, UserMapper userMapper, JwtUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.userMapper = userMapper;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public User create(UserDTO userDTO) {
        User newUser = userRepository.save(userMapper.dtoToEntity(userDTO));

        // Create a cart for the user
        Cart newCart = new Cart();
        newCart.setUser(newUser);
        newCart.setOrderStatus(OrderStatus.PENDING);
        cartRepository.save(newCart);

        return newUser;
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

    public UserDTO loadUserDTOByUsername(String username) {
        return userMapper.entityToDto(loadUserByUsername(username));
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
