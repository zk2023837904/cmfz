package com.baizhi.entity;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String name;
    private String password;
}
