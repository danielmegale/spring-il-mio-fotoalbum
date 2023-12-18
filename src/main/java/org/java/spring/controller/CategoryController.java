package org.java.spring.controller;

import java.util.List;

import org.java.spring.pojo.Category;
import org.java.spring.pojo.FotoAlbum;
import org.java.spring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
    public String listCategoryies(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category/category-list";
    }

    @GetMapping("/categories/create")
    public String createCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        System.out.println(category.getNome());
        return "category/category-form";
    }

    @PostMapping("/categories/create")
    public String storeCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        if (category != null) {
            model.addAttribute("category", category);
            model.addAttribute("actionUrl", "/categories/edit/" + id);
            return "category/category-form";
        } else {
            return "redirect:/categories";
        }
    }

    @PostMapping("/categories/edit/{id}")
    public String updateCategory(@PathVariable int id, @ModelAttribute Category category) {
        category.setId(id);
        categoryService.save(category);

        return "redirect:/categories";
    }

    
    @PostMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        
        for (FotoAlbum foto : category.getPhotos()) {
            foto.getCategories().remove(category);
        }
        
        categoryService.delete(category);
        return "redirect:/categories";
    }
}
