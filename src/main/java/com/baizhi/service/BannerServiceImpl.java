package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;
import com.baizhi.mapper.BannerMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerMapper bm;

    @Override
    public BannerDto queryAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        BannerDto bannerDto = new BannerDto();
        bannerDto.setRows(bm.selectAll());
        bannerDto.setTotal(bm.selectCount(null));
        return bannerDto;
    }

    @Override
    public void update(Banner banner) {
        bm.updateByPrimaryKey(banner);
    }

    @Override
    public void insert(Banner banner) {
        bm.insert(banner);
    }

    @Override
    public void delete(Integer id) {
        Banner banner = new Banner();
        banner.setId(id);
        System.out.println(banner);
        bm.deleteByPrimaryKey(banner);
    }
}
