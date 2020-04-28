package com.app.api.web.manager;

import com.app.api.domain.category.Category;
import com.app.api.service.category.CategoryService;
import com.app.api.web.dto.CategoryResponseDto;
//import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("")
    public void makeCategory(CategoryResponseDto dto){
       service.createCategory(dto);
    }

    @DeleteMapping("/{seq}")
    public void removeCategory(@PathVariable long seq){
       service.removeCategory(seq);
    }

    @PutMapping("/{seq")
    public void updateCategory(@PathVariable long seq , CategoryResponseDto dto){
       service.updateCategory(seq , dto);
    }

    @GetMapping("")
    public List<Category> showCategories(){
       return service.getCategories();
    }

    @GetMapping("/{seq}")
    public Category showCategory(@PathVariable long seq) {
        return service.getCategory(seq);
    }

}
