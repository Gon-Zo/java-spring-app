package com.app.api.domain.url;

import com.app.api.domain.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Table(name = "app_url")
@NoArgsConstructor
public class Url extends BaseEntity {

    // Auth Url
    @Column(name = "title")
    private String title;

}
