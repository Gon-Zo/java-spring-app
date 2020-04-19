package com.app.api.domain.image.support;

import com.app.api.domain.image.Image;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class ImageSupportImpl extends QuerydslRepositorySupport implements ImageSupport {

    private final JpaRepositoryFactory jpaRepositoryFactory;

    public ImageSupportImpl( JpaRepositoryFactory jpaRepositoryFactory) {
        super(Image.class);
        this.jpaRepositoryFactory = jpaRepositoryFactory;
    }

}
