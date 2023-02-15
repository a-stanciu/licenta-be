package alin.licenta.be.services;

import alin.licenta.be.dto.AttributeDTO;
import alin.licenta.be.entities.Attribute;
import alin.licenta.be.mappers.AttributeMapper;
import alin.licenta.be.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;

    private final AttributeMapper attributeMapper;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository, AttributeMapper attributeMapper) {
        this.attributeRepository = attributeRepository;
        this.attributeMapper = attributeMapper;
    }

    public Attribute create(AttributeDTO attributeDTO) {
        return attributeRepository.save(attributeMapper.dtoToEntity(attributeDTO));
    }

    public Attribute update(int id, AttributeDTO attributeDTO) {
        attributeDTO.setId(id);
        return attributeRepository.save(attributeMapper.dtoToEntity(attributeDTO));
    }

    public void deleteById(int id) {
        attributeRepository.deleteById(id);
    }

    public void deleteAll() {
        attributeRepository.deleteAll();
    }

    public Attribute findEntityById(int id) {
        return attributeRepository
                .findById(id)
                .orElse(null);
    }

    public AttributeDTO findDTOById(int id) {
        return attributeMapper.entityToDto(findEntityById(id));
    }

    public List<AttributeDTO> findAll() {
        return attributeRepository
                .findAll()
                .stream()
                .map(attributeMapper::entityToDto)
                .toList();
    }
}
