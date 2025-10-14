package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DishMapper {
    /**
     * 根据分类id查询关联的菜品数量
     * @param id
     * @return
     */
    @Select("select count(1) from dish where category_id = #{id}")
    int countByCategoryId(Long id);
}
