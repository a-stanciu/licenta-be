package alin.licenta.be.services;

import alin.licenta.be.dto.VariantDTO;
import alin.licenta.be.entities.Variant;
import alin.licenta.be.mappers.VariantMapper;
import alin.licenta.be.repositories.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    private final VariantMapper variantMapper;

    @Autowired
    public VariantService(VariantRepository variantRepository, VariantMapper variantMapper) {
        this.variantRepository = variantRepository;
        this.variantMapper = variantMapper;
    }

    public Variant create(VariantDTO variantDTO) {
        return variantRepository.save(variantMapper.dtoToEntity(variantDTO));
    }

    public Variant update(int id, VariantDTO variantDTO) {
        variantDTO.setId(id);
        return variantRepository.save(variantMapper.dtoToEntity(variantDTO));
    }

    public void deleteById(int id) {
        variantRepository.deleteById(id);
    }

    public void deleteAll() {
        variantRepository.deleteAll();
    }

    public Variant findEntityById(int id) {
        return variantRepository
                .findById(id)
                .orElse(null);
    }

    public VariantDTO findDTOById(int id) {
        return variantMapper.entityToDto(findEntityById(id));
    }

    public List<VariantDTO> findAll() {
        return variantRepository
                .findAll()
                .stream()
                .map(variantMapper::entityToDto)
                .toList();
    }
}
