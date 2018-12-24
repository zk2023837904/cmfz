package com.baizhi.controller;

import com.baizhi.dto.AlbumDto;
import com.baizhi.entity.Album;
import com.baizhi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    AlbumService as;

    @RequestMapping("getAll")
    public AlbumDto getAll(int page, int rows) {
        AlbumDto albumDto = as.queryAll(page, rows);
        return albumDto;
    }

    @RequestMapping("getOne")
    public List<Album> queryOne(Integer id) {
        List<Album> list = new ArrayList<>();
        Album album = as.queryOne(id);
        list.add(album);
        return list;
    }

    @RequestMapping("insert")
    public void insert(Album album, MultipartFile file1, HttpSession session) throws IllegalStateException, IOException {
        String srcname = file1.getOriginalFilename();
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/album");
        File descFile = new File(realPath + "/" + srcname);
        file1.transferTo(descFile);
        album.setCoverImg("/album/" + srcname);
        System.out.println(album);
        as.insert(album);
    }

}
