package com.app.api.web;

import com.app.api.domain.store.Store;
import com.app.api.service.store.StoreService;
import com.app.api.web.dto.StoreRepoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store")
@AllArgsConstructor
@RestController
public class StoreController {

    private final StoreService service;

    @PostMapping("")
    public void createStore(@RequestBody StoreRepoenseDto dto) {
        service.createStore(dto);
    }

    @GetMapping("")
    public List<Store> showList() {
        return service.getStores();
    }

    @GetMapping("/{seq}")
    public Store showStore(@PathVariable long seq){
        return service.getStore(seq);
    }

    @PutMapping("/{seq}")
    public void modifyStore(@PathVariable long seq, @RequestBody StoreRepoenseDto dto) {
        service.updateInfo(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeStore(@PathVariable long seq){
        service.removeStore(seq);
    }

}
