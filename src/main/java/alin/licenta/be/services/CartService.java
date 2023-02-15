package alin.licenta.be.services;

import alin.licenta.be.dto.CartDTO;
import alin.licenta.be.entities.Cart;
import alin.licenta.be.mappers.CartMapper;
import alin.licenta.be.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final CartMapper cartMapper;

    @Autowired
    public CartService(CartRepository cartRepository, CartMapper cartMapper) {
        this.cartRepository = cartRepository;
        this.cartMapper = cartMapper;
    }

    public Cart create(CartDTO cartDTO) {
        return cartRepository.save(cartMapper.dtoToEntity(cartDTO));
    }

    public Cart update(int id, CartDTO cartDTO) {
        cartDTO.setId(id);
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
                .findByUser(userId)
                .stream()
                .map(cartMapper::entityToDto)
                .toList();
    }

    public CartDTO findCurrentByUser(int userId) {
        return cartMapper.entityToDto(cartRepository.findCurrentByUser(userId));
    }
}
