package com.app.api.domain.image;

import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_image")
public class Image extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "photo")
    private String photo;

}
