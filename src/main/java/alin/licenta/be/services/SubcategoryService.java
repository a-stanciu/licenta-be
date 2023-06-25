package alin.licenta.be.services;

import alin.licenta.be.dto.SubcategoryRequestDTO;
import alin.licenta.be.dto.SubcategoryResponseDTO;
import alin.licenta.be.entities.Subcategory;
import alin.licenta.be.mappers.SubcategoryMapper;
import alin.licenta.be.repositories.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    private final SubcategoryMapper subcategoryMapper;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository, SubcategoryMapper subcategoryMapper) {
        this.subcategoryRepository = subcategoryRepository;
        this.subcategoryMapper = subcategoryMapper;
    }

    public Subcategory create(SubcategoryRequestDTO subcategoryRequestDTO) {
        return subcategoryRepository.save(subcategoryMapper.dtoToEntity(subcategoryRequestDTO));
    }

    public Subcategory update(int id, SubcategoryRequestDTO subcategoryRequestDTO) {
        subcategoryRequestDTO.setId(id);
        return subcategoryRepository.save(subcategoryMapper.dtoToEntity(subcategoryRequestDTO));
    }

    public void deleteById(int id) {
        subcategoryRepository.deleteById(id);
    }

    public void deleteAll() {
        subcategoryRepository.deleteAll();
    }

    public Subcategory findEntityById(int id) {
        return subcategoryRepository
                .findById(id)
                .orElse(null);
    }

    public SubcategoryResponseDTO findDTOById(int id) {
        return subcategoryMapper.entityToDto(findEntityById(id));
    }

    public List<SubcategoryResponseDTO> findAll() {
        return subcategoryRepository
                .findAll()
                .stream()
                .map(subcategoryMapper::entityToDto)
                .toList();
    }
}
