package com.baizhi;

import com.baizhi.entity.Chapter;

import com.baizhi.service.AlbumService;
import com.baizhi.service.BannerService;
import com.baizhi.service.ChapterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    ChapterService cs;
    @Autowired
    BannerService bannerService;
    @Autowired
    AlbumService as;
    @Test
    public void contextLoads() {
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        Chapter c=new Chapter(uuid, "真假美猴王", "233MB", "45:30", "/audio/1.mp3", new Date(), 1);
        cs.insert(c);
    }


    @Test
    public void contextLoads1() {
        System.out.println(bannerService.queryAll(1,3));
    }

    @Test
    public void contextLoads2() {
        System.out.println(as.queryAll(1,4));
    }


}

