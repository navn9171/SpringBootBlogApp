package com.blog.app.service;

import com.blog.app.dto.CategoryDto;

import java.util.List;

public interface CategoryService {

	CategoryDto createCategory(CategoryDto categoryDto);

	List<CategoryDto> getAllCategories();

	CategoryDto getCategoryById(Integer id);

	CategoryDto updateCategory(CategoryDto categoryDto, Integer id);

	void deleteCategory(Integer id);
}
