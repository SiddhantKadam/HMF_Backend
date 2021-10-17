package com.project.HMF.Service.impl;

import com.project.HMF.Dao.BannerDao;
import com.project.HMF.Dao.CategoryDao;
import com.project.HMF.Model.BannerMaster;
import com.project.HMF.Model.CategoryMaster;
import com.project.HMF.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public boolean categoryCreate(CategoryMaster categoryMaster) {
        try {
            categoryDao.save(categoryMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean categoryUpdate(CategoryMaster categoryMaster) {
        try {
            categoryDao.save(categoryMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllCategory() {
        return (List) categoryDao.findAll();
    }

    @Override
    public CategoryMaster getCategoryById(Integer categoryId) {
        CategoryMaster categoryMaster = new CategoryMaster();
        try {
            categoryMaster = categoryDao.findOne(categoryId);
            return categoryMaster;
        } catch (Exception e) {
            e.printStackTrace();
            return categoryMaster;
        }
    }

    @Override
    public List activeCategory() {
        List list = categoryDao.findAllByStatus("Active");
        return list;
    }
}
