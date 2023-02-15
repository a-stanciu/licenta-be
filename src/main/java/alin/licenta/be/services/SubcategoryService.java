package alin.licenta.be.services;

import alin.licenta.be.dto.SubcategoryDTO;
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

    public Subcategory create(SubcategoryDTO subcategoryDTO) {
        return subcategoryRepository.save(subcategoryMapper.dtoToEntity(subcategoryDTO));
    }

    public Subcategory update(int id, SubcategoryDTO subcategoryDTO) {
        subcategoryDTO.setId(id);
        return subcategoryRepository.save(subcategoryMapper.dtoToEntity(subcategoryDTO));
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

    public SubcategoryDTO findDTOById(int id) {
        return subcategoryMapper.entityToDto(findEntityById(id));
    }

    public List<SubcategoryDTO> findAll() {
        return subcategoryRepository
                .findAll()
                .stream()
                .map(subcategoryMapper::entityToDto)
                .toList();
    }
}
