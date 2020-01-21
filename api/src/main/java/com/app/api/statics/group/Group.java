package com.app.api.statics.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_group")
public class Group {

    @Id
    private long seq;

    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

}
