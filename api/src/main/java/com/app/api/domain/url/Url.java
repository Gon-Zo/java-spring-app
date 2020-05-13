package com.app.api.domain.url;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "URLS")
@NoArgsConstructor
public class Url extends BaseEntity {

    // Auth Url
    @Column(name = "title")
    private String title;

    @Builder
    public Url(String title) {
        this.title = title;
    }

}
