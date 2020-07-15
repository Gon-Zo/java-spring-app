package com.app.api.web.manager;

import com.app.api.domain.category.Category;
import com.app.api.service.category.CategoryService;
import com.app.api.web.dto.CategoryResponseDto;
import com.app.api.web.dto.PageableDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/manager/category")
@AllArgsConstructor
public class ManagerCategoryController {

    private final CategoryService service;

    @PostMapping("")
    public void makeCategory(CategoryResponseDto dto){
       service.createCategory(dto);
    }

    @DeleteMapping("/{seq}")
    public void removeCategory(@PathVariable @NotNull long seq){
       service.removeCategory(seq);
    }

    @PutMapping("/{seq")
    public void updateCategory(@PathVariable @NotNull long seq , CategoryResponseDto dto){
       service.updateCategory(seq , dto);
    }

    @GetMapping("/")
    public List<Category> showCategories(){
       return service.getCategories();
    }

    @GetMapping("/{seq}")
    public Category showCategory(@PathVariable @NotNull long seq) {
        return service.getCategory(seq);
    }

    @GetMapping("")
    public Page<Category> showPages(PageableDto dto) {
        return service.getPages(dto);
    }

}
