package org.example.extraclasses.api.action;

import org.example.extraclasses.api.Action;
import org.example.extraclasses.api.Forward;
import org.example.extraclasses.dao.CategoryDao;
import org.example.extraclasses.dao.impl.CategoryDaoImpl;
import org.example.extraclasses.entity.CategoryInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class NewAction extends Action {
    Logger log = Logger.getLogger(NewAction.class.getName());
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("Start action : "+this.getClass().getName());
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<CategoryInfo> category = categoryDao.findAll();
        request.setAttribute("categories",category);
        return new Forward("/category/table");
    }
}
