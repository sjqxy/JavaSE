package com.sjq.dao;

import org.springframework.stereotype.Component;

@Component("bookDao")
public class BookDaoImpl implements BookDao{
    @Override
    public void save() {
        System.out.println("wxhn");
    }
}
