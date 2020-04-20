package com.app.api.service.store;

import com.app.api.domain.store.Store;
import com.app.api.web.dto.StoreRepoenseDto;

import java.util.List;

public interface StoreService {

    /**
     * Store Uesr Save
     *
     * @param dto
     */
    void createStore(StoreRepoenseDto dto);

    /**
     * get Store List
     *
     * @return
     */
    List<Store> getStores();

    /**
     * Store Info Update
     *
     * @param seq
     * @param dto
     */
    void updateInfo(long seq , StoreRepoenseDto dto);

    /**
     * Store Delete
     *
     * @param seq
     */
    void removeStore(long seq);

    /**
     * select one store info
     *
     * @param seq
     * @return
     */
    Store getStore(long seq);
}
