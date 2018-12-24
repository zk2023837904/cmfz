package com.baizhi.service;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;

public interface AlbumService {
    public AlbumDto queryAll(int page, int rows);
    public Album queryOne(Integer id);
    public void insert(Album album);
}
