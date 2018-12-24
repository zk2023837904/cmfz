package com.baizhi.dto;

import com.baizhi.entity.Album;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDto implements Serializable {
    private  Integer total;
    private List<Album> rows;
}
