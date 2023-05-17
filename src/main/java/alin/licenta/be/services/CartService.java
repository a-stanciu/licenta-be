package alin.licenta.be.services;

import alin.licenta.be.dto.CartDTO;
import alin.licenta.be.entities.Cart;
import alin.licenta.be.mappers.CartMapper;
import alin.licenta.be.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    private final UserService userService;

    @Autowired
    public CartService(CartRepository cartRepository, CartMapper cartMapper, UserService userService) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
        this.userService = userService;
    }

    public Cart create(CartDTO cartDTO) {
        cartDTO.setLastModified(new Date());
        return cartRepository.save(cartMapper.dtoToEntity(cartDTO));
    }

    public Cart update(int id, CartDTO cartDTO) {
        cartDTO.setId(id);
        cartDTO.setLastModified(new Date());
        return cartRepository.save(cartMapper.dtoToEntity(cartDTO));
    }

    public void deleteById(int id) {
        cartRepository.deleteById(id);
    }

    public void deleteAll() {
        cartRepository.deleteAll();
    }

    public Cart findEntityById(int id) {
        return cartRepository
                .findById(id)
                .orElse(null);
    }

    public CartDTO findDTOById(int id) {
        return cartMapper.entityToDto(findEntityById(id));
    }

    public List<CartDTO> findAll() {
        return cartRepository
                .findAll()
                .stream()
                .map(cartMapper::entityToDto)
                .toList();
    }

    public List<CartDTO> findByUser(int userId) {
        return cartRepository
                .findCartsByUser(
                        userService.findEntityById(userId)
                )
                .stream()
                .map(cartMapper::entityToDto)
                .toList();
    }

    public CartDTO findCurrentByUser(int userId) {
        return cartMapper.entityToDto(
                cartRepository.findTop1CartByUserOrderByLastModifiedDesc(
                        userService.findEntityById(userId)
                )
        );
    }
}
