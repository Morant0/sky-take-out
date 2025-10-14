package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetmealMapper {
    /**
     * 根据分类id查询关联的套餐数量
     * @param id
     * @return
     */
    @Select("select count(1) from setmeal where category_id = #{id}")
    int countByCategoryId(Long id);
}
