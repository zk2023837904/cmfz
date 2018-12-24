package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
public class Album {
    private Integer id;
    private String title;
    private Integer count;
    private String coverImg;
    private String score;
    private String author;
    private String broadcast;
    private String brief;
    @JsonFilter("yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pubDate;
    @Transient
    private List<Chapter> children;
}
