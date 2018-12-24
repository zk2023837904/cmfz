package com.baizhi.entity;

import lombok.*;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private String headPic;
    private String name;
    private String dharma;
    private String province;
    private String city;
    private Boolean sex;
    private Boolean status;
    private Date regDate;
}
