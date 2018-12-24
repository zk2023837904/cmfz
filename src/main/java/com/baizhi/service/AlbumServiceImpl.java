package com.baizhi.service;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;
import com.baizhi.mapper.AlbumMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    AlbumMapper am;

    @Override
    public AlbumDto queryAll(int page, int rows) {
        PageHelper.startPage(page, rows);
        AlbumDto albumDto = new AlbumDto();
        albumDto.setRows( am.queryAll(page,rows));
        albumDto.setTotal(am.selectCount(null));
        return albumDto;
    }

    @Override
    public Album queryOne(Integer id) {
        Album album = new Album();
        album.setId(id);
        return am.selectOne(album);
    }

    @Override
    public void insert(Album album) {
        am.insert(album);
    }

}
