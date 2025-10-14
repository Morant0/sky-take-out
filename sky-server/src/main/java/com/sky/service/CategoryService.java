package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;

import java.util.List;

public interface CategoryService {
    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 分类添加
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * 分类状态禁用/启用
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 分类编辑
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * 分类删除
     * @param id
     */
    void deleteById(Long id);

    /**
     * 根据类型查询分类
     * @param type
     * @return
     */
    List<Category> list(Integer type);
}
