package com.ditto.ditto.controller;

import com.ditto.ditto.dto.CategoryDto;
import com.ditto.ditto.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donor")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // 카테고리 생성 후 저장
    @PostMapping("/choice/{helperId}")
    public void create(@PathVariable("helperId") Long helperId, @RequestBody CategoryDto categoryDto) {
        categoryService.create(helperId, categoryDto);
    }
}
