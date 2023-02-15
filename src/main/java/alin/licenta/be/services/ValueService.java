package alin.licenta.be.services;

import alin.licenta.be.dto.ValueDTO;
import alin.licenta.be.entities.Value;
import alin.licenta.be.mappers.ValueMapper;
import alin.licenta.be.repositories.ValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValueService {

    private final ValueRepository valueRepository;

    private final ValueMapper valueMapper;

    @Autowired
    public ValueService(ValueRepository valueRepository, ValueMapper valueMapper) {
        this.valueRepository = valueRepository;
        this.valueMapper = valueMapper;
    }

    public Value create(ValueDTO valueDTO) {
        return valueRepository.save(valueMapper.dtoToEntity(valueDTO));
    }

    public Value update(int id, ValueDTO valueDTO) {
        valueDTO.setId(id);
        return valueRepository.save(valueMapper.dtoToEntity(valueDTO));
    }

    public void deleteById(int id) {
        valueRepository.deleteById(id);
    }

    public void deleteAll() {
        valueRepository.deleteAll();
    }

    public Value findEntityById(int id) {
        return valueRepository
                .findById(id)
                .orElse(null);
    }

    public ValueDTO findDTOById(int id) {
        return valueMapper.entityToDto(findEntityById(id));
    }

    public List<ValueDTO> findAll() {
        return valueRepository
                .findAll()
                .stream()
                .map(valueMapper::entityToDto)
                .toList();
    }
}
