package com.ditto.ditto.service;

import com.ditto.ditto.dto.CategoryDto;
import com.ditto.ditto.entity.CategoryEntity;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.CategoryRepository;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final HelperRepository helperRepository;
    public void create(Long helperId, CategoryDto categoryDto) {
        HelperEntity helperEntity = helperRepository.findById(helperId).get();
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategory(categoryDto.getCategory());
        categoryEntity.setHelperEntity(helperEntity);
        categoryRepository.save(categoryEntity);

        helperEntity.setCategoryEntity(categoryEntity);
    }

}
