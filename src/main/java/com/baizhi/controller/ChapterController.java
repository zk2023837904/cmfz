package com.baizhi.controller;

import com.baizhi.entity.Chapter;
import com.baizhi.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@RestController
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService cs;
    @RequestMapping("insert")
    public void insert(Chapter chapter, MultipartFile file1, Integer chapterid,HttpSession session) throws IllegalStateException, IOException {
        String srcname = file1.getOriginalFilename();
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/chapter");
        File descFile = new File(realPath + "/" + srcname);
        file1.transferTo(descFile);
        chapter.setUrl("/chapter/" + srcname);
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        chapter.setId(uuid);
        chapter.setPid(chapterid);
        cs.insert(chapter);
    }
    @RequestMapping("dol")
    public void filedownload(String url, HttpSession session, HttpServletResponse response) throws IOException{
        // 获取server端文件的 字节数组
        String realPath = session.getServletContext().getRealPath("");
        File srcFile = new File(realPath+"/"+url);
        byte[] bs = FileUtils.readFileToByteArray(srcFile);
        // 设置响应头信息，以附件的形式下载
        response.setHeader("content-disposition", "attchment;filename="+ URLEncoder.encode(url, "utf-8"));
        // 使用响应输出流，往client输出文件内容
        ServletOutputStream sos = response.getOutputStream();
        sos.write(bs);
    }
}
