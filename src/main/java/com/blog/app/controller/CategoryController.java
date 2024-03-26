package com.blog.app.controller;

import com.blog.app.dto.CategoryDto;
import com.blog.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto category = categoryService.createCategory(categoryDto);
		return new ResponseEntity<>(category, HttpStatus.CREATED);
	}

	@GetMapping("all")
	public ResponseEntity<?> getALlCategories(){
		List<CategoryDto> allCategories = categoryService.getAllCategories();
		return new ResponseEntity<>(allCategories, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Integer id){
		CategoryDto categoryById = categoryService.getCategoryById(id);
		return new ResponseEntity<>(categoryById, HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer id){
		CategoryDto c = categoryService.updateCategory(categoryDto, id);
		return new ResponseEntity<>(c, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable Integer id){
		categoryService.deleteCategory(id);
		return new ResponseEntity<>("Category Deleted Successfully", HttpStatus.OK);
	}
}
