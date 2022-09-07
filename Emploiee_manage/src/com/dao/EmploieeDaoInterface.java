package com.dao;

import com.module.Emploiee;

public interface EmploieeDaoInterface {
    public boolean insertEmploiee(Emploiee s);
    public boolean delete(int emp_id);
    public boolean update(int emp_id,String update,int ch,Emploiee s);
    public void showAllEmploiee();
    public boolean showEmploieeById(int emp_id);
}