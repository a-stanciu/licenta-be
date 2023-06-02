package alin.licenta.be.services;

import alin.licenta.be.dto.AssignedValueDTO;
import alin.licenta.be.entities.AssignedValue;
import alin.licenta.be.mappers.AssignedValueMapper;
import alin.licenta.be.repositories.AssignedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignedValueService {

    private final AssignedValueRepository assignedValueRepository;

    private final AssignedValueMapper assignedValueMapper;

    @Autowired
    public AssignedValueService(AssignedValueRepository assignedValueRepository, AssignedValueMapper assignedValueMapper) {
        this.assignedValueRepository = assignedValueRepository;
        this.assignedValueMapper = assignedValueMapper;
    }


    public AssignedValue create(AssignedValueDTO assignedValueDTO) {
        return assignedValueRepository.save(assignedValueMapper.dtoToEntity(assignedValueDTO));
    }

    public AssignedValue update(int id, AssignedValueDTO assignedValueDTO) {
        assignedValueDTO.setId(id);
        return assignedValueRepository.save(assignedValueMapper.dtoToEntity(assignedValueDTO));
    }

    public void deleteById(int id) {
        assignedValueRepository.deleteById(id);
    }

    public void deleteAll() {
        assignedValueRepository.deleteAll();
    }

    public AssignedValue findEntityById(int id) {
        return assignedValueRepository
                .findById(id)
                .orElse(null);
    }

    public AssignedValueDTO findDTOById(int id) {
        return assignedValueMapper.entityToDto(findEntityById(id));
    }

    public List<AssignedValueDTO> findAll() {
        return assignedValueRepository
                .findAll()
                .stream()
                .map(assignedValueMapper::entityToDto)
                .toList();
    }
}
