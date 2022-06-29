package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    List<Brand> selectAll();


    @Insert("insert into tb_brand values(null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    int insertBrand(Brand b);

    @Delete("delete from tb_brand where id=#{id}")
    int delById(String id);

    @Select("select * from tb_brand where id=#{id}")
    Brand findBrandById(String id);


    int updateBrand(Brand b);
}
