package com.baizhi.controller;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    BannerService bs;

    @RequestMapping("getAll")
    public BannerDto queryAll(int page, int rows) {
        BannerDto bannerDto = bs.queryAll(page, rows);
        return bannerDto;
    }

    @RequestMapping("update")
    public void update(Banner banner) {
        bs.update(banner);
    }

    @RequestMapping("delete")
    public void delete(Integer id, String imgPath, HttpSession session) {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("");
        File descFile = new File(realPath + "/" + imgPath);
        descFile.delete();
        bs.delete(id);
    }

    @RequestMapping("insert")
    public void insert(Banner banner, MultipartFile file1, HttpSession session) throws IllegalStateException, IOException {
        String srcname = file1.getOriginalFilename();
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/image/shouye");
        File descFile = new File(realPath + "/" + srcname);
        file1.transferTo(descFile);
        banner.setImgPath("/image/shouye/" + srcname);
        System.out.println(banner);
        bs.insert(banner);
    }


}
