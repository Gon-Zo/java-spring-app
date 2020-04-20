package com.app.api.service.store;

import com.app.api.domain.store.Store;
import com.app.api.domain.store.StoreRepository;
import com.app.api.domain.store.support.StoreSupport;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.global.error.exception.BusinessException;
import com.app.api.global.error.exception.ErrorCode;
import com.app.api.web.dto.StoreRepoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final StoreSupport support;

    private final StoreRepository repository;

    private final UserRepository userRepository;

    @Override
    public void createStore(StoreRepoenseDto dto) {

        User user =
                userRepository.findById(dto.getUserSeq())
                        .orElseThrow(() ->
                                new BusinessException(ErrorCode.USER_NOT_FOUND));

        dto.setUser(user);

        repository.save(dto.toEntity());
    }

    @Override
    public List<Store> getStores() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void updateInfo(long seq, StoreRepoenseDto dto) {
        support.update(seq, dto);
    }

    @Override
    @Transactional
    public void removeStore(long seq) {
        repository.deleteById(seq);
    }

    @Override
    public Store getStore(long seq) {
        return repository.findById(seq)
                .orElseThrow(()-> new BusinessException(ErrorCode.STORE_NOT_FOUND));
    }


}
