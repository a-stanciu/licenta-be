package alin.licenta.be.services;

import alin.licenta.be.dto.ProductResponseDTO;
import alin.licenta.be.entities.Product;
import alin.licenta.be.mappers.ProductMapper;
import alin.licenta.be.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product create(ProductResponseDTO productResponseDTO) {
        return productRepository.save(productMapper.dtoToEntity(productResponseDTO));
    }

    public Product update(int id, ProductResponseDTO productResponseDTO) {
        productResponseDTO.setId(id);
        return productRepository.save(productMapper.dtoToEntity(productResponseDTO));
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public Product findEntityById(int id) {
        return productRepository
                .findById(id)
                .orElse(null);
    }

    public ProductResponseDTO findDTOById(int id) {
        return productMapper.entityToDto(findEntityById(id));
    }

    public List<ProductResponseDTO> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(productMapper::entityToDto)
                .toList();
    }
}
