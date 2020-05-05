package com.app.api.domain.image;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
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

    @Column(name = "photo" , columnDefinition = "TEXT")
    private String photo;

    @Column(name = "type")
    private String type;

    @Column(name = "data_id")
    private Long dataId;

    @Builder
    public Image(String photo, String type, Long dataId) {
        this.photo = photo;
        this.type = type;
        this.dataId = dataId;
    }

}
