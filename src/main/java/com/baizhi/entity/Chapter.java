package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
public class Chapter {
    @Id
    private String id;
    private String title;
    private String size;
    private String duration;
    private String url;
    @JsonFilter("yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date uploadDate;
    private Integer pid;
}
