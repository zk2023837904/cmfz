package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banner")
public class Banner implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;
    private String title;
    private String imgPath;
    private String status;
    @JsonFilter("yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    private String description;
}
