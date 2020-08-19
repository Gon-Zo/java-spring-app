package com.app.api.domain.store.support;

import com.app.api.web.dto.StoreDto;

public interface StoreSupport {

    void update(long seq , StoreDto dto);

}
