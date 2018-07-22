package com.yek.mybatis.mapper;

import com.yek.mybatis.entity.Country;

import java.util.List;

/**
 * Created by yek on 2018-07-22.
 */
public interface CountryMapper {
    public List<Country> selectAll();
}
