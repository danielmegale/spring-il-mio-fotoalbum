package org.java.spring.service;

import java.util.List;

import org.java.spring.pojo.Category;
import org.java.spring.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	public Category findById(int id){
		return categoryRepository.findById(id).get();
	}
	
	public void save(Category category) {
		categoryRepository.save(category);
	}
	public void delete(Category category) {
		
		categoryRepository.delete(category);
	}
}