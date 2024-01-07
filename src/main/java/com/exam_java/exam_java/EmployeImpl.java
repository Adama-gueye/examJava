package com.exam_java.exam_java;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeImpl implements IEmploye{

    DBConnexion db = new DBConnexion();
    @Override
    public List<Employe> getAll() {
        String sql = "SELECT * FROM employe ORDER BY nomE ASC";

        List<Employe> employes = new ArrayList<Employe>();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                Employe employe = new Employe();
                employe.setIdE(rs.getInt(1));
                employe.setNomE(rs.getString(2));
                employe.setPrenomE(rs.getString(3));
                employe.setEmailE(rs.getString(4));
                employe.setDept(new DepartementImpl().get(rs.getInt(5)));

                employes.add(employe);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return employes;
    }
}
