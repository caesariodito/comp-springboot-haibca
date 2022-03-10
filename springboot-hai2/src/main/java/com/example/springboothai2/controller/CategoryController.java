package com.example.springboothai2.controller;

import com.example.springboothai2.dao.CategoryRepository;
import com.example.springboothai2.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping({"/list", "/"})
    public ModelAndView getAllCategories(){
        ModelAndView mav = new ModelAndView("list-categories");
        mav.addObject("categories", categoryRepository.findAll());
        return mav;
    }

    @GetMapping("/addCategoryForm")
    public ModelAndView addCategoryForm() {
        ModelAndView mav = new ModelAndView("add-category-form");
        Category newCategory = new Category();
        mav.addObject("category", newCategory);
        return mav;
    }

    @PostMapping("/saveCategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/list";
    }

    @GetMapping("/showUpdateFormCategory")
    public ModelAndView showUpdateForm(@RequestParam long categoryId) {
        ModelAndView mav = new ModelAndView("add-category-form");
        Category category = categoryRepository.findById(categoryId).get();
        mav.addObject("category", category);
        return mav;
    }

    @GetMapping("/deleteCategory")
    public String deleteCategory(@RequestParam long categoryId) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/list";
    }

}
