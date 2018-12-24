package com.baizhi.service;

import com.baizhi.dto.BannerDto;
import com.baizhi.entity.Banner;



public interface BannerService {
    public BannerDto queryAll(int page, int rows);

    public void update(Banner banner);

    public void insert(Banner banner);

    public void delete(Integer id);
}
