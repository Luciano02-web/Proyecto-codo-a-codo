package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Producto;

public class ProductoDAO {
 
    public List<Producto> listar() {
        try {
            
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from productos");
            
            // recorro todas las peliculas
            // creo un objeto Pelicula x cada peli o fila
            List<Producto> listProd=new ArrayList<Producto>();
            while (rs.next()) {
                // orm: mapeo relacional objeto, lo hacen framework hibernate, jpa
                Producto prod=new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                listProd.add(prod);
            }         
            
            return listProd;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        
    }
}
