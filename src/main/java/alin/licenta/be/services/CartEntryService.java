package alin.licenta.be.services;

import alin.licenta.be.dto.CartEntryDTO;
import alin.licenta.be.entities.CartEntry;
import alin.licenta.be.mappers.CartEntryMapper;
import alin.licenta.be.repositories.CartEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartEntryService {

    private final CartEntryRepository cartEntryRepository;

    public final CartEntryMapper cartEntryMapper;

    @Autowired
    public CartEntryService(CartEntryRepository cartEntryRepository, CartEntryMapper cartEntryMapper) {
        this.cartEntryRepository = cartEntryRepository;
        this.cartEntryMapper = cartEntryMapper;
    }

    public CartEntry create(CartEntryDTO cartEntryDTO) {
        return cartEntryRepository.save(cartEntryMapper.dtoToEntry(cartEntryDTO));
    }

    public CartEntry update(int id, CartEntryDTO cartEntryDTO) {
        cartEntryDTO.setId(id);
        return cartEntryRepository.save(cartEntryMapper.dtoToEntry(cartEntryDTO));
    }

    public void deleteById(int id) {
        cartEntryRepository.deleteById(id);
    }

    public void deleteAll() {
        cartEntryRepository.deleteAll();
    }

    public CartEntry findEntityById(int id) {
    return cartEntryRepository
            .findById(id)
            .orElse(null);
    }

    public CartEntryDTO findDTOById(int id) {
        return cartEntryMapper.entityToDto(findEntityById(id));
    }

    public List<CartEntryDTO> findAll() {
        return cartEntryRepository
                .findAll()
                .stream()
                .map(cartEntryMapper::entityToDto)
                .toList();
    }
}
