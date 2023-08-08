package com.ditto.ditto.service;

import com.ditto.ditto.dto.CategoryDto;
import com.ditto.ditto.entity.CategoryEntity;
import com.ditto.ditto.entity.HelperEntity;
import com.ditto.ditto.repository.CategoryRepository;
import com.ditto.ditto.repository.HelperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryService {
    private final HelperRepository helperRepository;
    private final CategoryRepository categoryRepository;
}
