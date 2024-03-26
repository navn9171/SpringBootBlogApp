package com.blog.app.service.Impl;

import com.blog.app.dto.CategoryDto;
import com.blog.app.entity.Category;
import com.blog.app.exception.ResourceNotFoundException;
import com.blog.app.repository.CategoryRepository;
import com.blog.app.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = modelMapper.map(categoryDto, Category.class);
		Category saved = categoryRepository.save(category);
		return modelMapper.map(saved, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> allCategories = categoryRepository.findAll();
		List<CategoryDto> collect = allCategories.stream()
				.map(c -> modelMapper.map(c, CategoryDto.class))
				.collect(Collectors.toList());
		return collect;
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category Not Found with ID: " + id));
		return modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with the ID: " + id));
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		Category saved = categoryRepository.save(category);
		return modelMapper.map(saved, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer id) {
		Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category not found with the ID: " + id));
		categoryRepository.deleteById(category.getId());
	}
}
