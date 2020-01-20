package com.app.api.user;

import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepository;
import com.app.api.statics.user.UserRepositorySupport;
import com.app.api.statics.user.UserService;
import com.app.api.statics.user.impl.UserServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserUnitTest {

    /**
     * 유저 리스트 조회 단위 테스트
     */
    @Test
    public void 유저_단위테스트() {

        UserRepository repository = Mockito.mock(UserRepository.class);
        UserRepositorySupport userRepositorySupport = Mockito.mock(UserRepositorySupport.class);

        UserService userService = new UserServiceImpl(repository, userRepositorySupport);

        List<User> list = userService.allUser();

        list.stream().forEach(f->System.out.println(f));
    }


}
