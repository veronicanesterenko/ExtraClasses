package org.example.extraclasses.dao;

import org.example.extraclasses.entity.CategoryInfo;
import org.example.extraclasses.entity.SubjectInfo;

import java.util.List;

public interface CategoryDao {

    List<CategoryInfo> findAll();


}
