package com.exam_java.exam_java;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartementImpl implements IDepartement{
    DBConnexion db = new DBConnexion();
    @Override
    public List<Departement> getAll() {
        String sql = "SELECT * FROM departement ORDER BY nomD ASC";
        List<Departement> categories = new ArrayList<Departement>();
        try {
            db.initPrepar(sql);
            ResultSet rs = db.executeSelect();
            while (rs.next()) {
                Departement categorie = new Departement();
                categorie.setIdD(rs.getInt(1));
                categorie.setNomD(rs.getString(2));

                categories.add(categorie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Departement get(int id) {
        Departement departement = null;
        String sql = "SELECT * FROM departement WHERE idD=?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ResultSet rs = db.executeSelect();
            if (rs.next()) {
                departement = new Departement();
                departement.setIdD(rs.getInt("idD"));
                departement.setNomD(rs.getString("nomD"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return departement;
    }
}
