package alin.licenta.be.services;

import alin.licenta.be.dto.AttributeValueDTO;
import alin.licenta.be.entities.AttributeValue;
import alin.licenta.be.mappers.AttributeValueMapper;
import alin.licenta.be.repositories.AttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;

    private final AttributeValueMapper attributeValueMapper;

    @Autowired
    public AttributeValueService(AttributeValueRepository attributeValueRepository, AttributeValueMapper attributeValueMapper) {
        this.attributeValueRepository = attributeValueRepository;
        this.attributeValueMapper = attributeValueMapper;
    }

    public AttributeValue create(AttributeValueDTO attributeValueDTO) {
        return attributeValueRepository.save(attributeValueMapper.dtoToEntity(attributeValueDTO));
    }

    public AttributeValue update(int id, AttributeValueDTO attributeValueDTO) {
        attributeValueDTO.setId(id);
        return attributeValueRepository.save(attributeValueMapper.dtoToEntity(attributeValueDTO));
    }

    public void deleteById(int id) {
        attributeValueRepository.deleteById(id);
    }

    public void deleteAll() {
        attributeValueRepository.deleteAll();
    }

    public AttributeValue findEntityById(int id) {
        return attributeValueRepository
                .findById(id)
                .orElse(null);
    }

    public AttributeValueDTO findDTOById(int id) {
        return attributeValueMapper.entityToDto(findEntityById(id));
    }

    public List<AttributeValueDTO> findAll() {
        return attributeValueRepository
                .findAll()
                .stream()
                .map(attributeValueMapper::entityToDto)
                .toList();
    }
}
