package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.db.ConnectorDB;
import com.example.demo.model.Pelicula;





/**
 * Esta clase agrupa todas la consultas a la tabla peliculas.
 * Consultas, insert, upd, y del
 * 
 */
public class PeliculaDAO {
 
    public List<Pelicula> listar() {
        try {
            
            Statement st=ConnectorDB.getSt();
            ResultSet rs=st.executeQuery("Select * from peliculas");
            
            // recorro todas las peliculas
            // creo un objeto Pelicula x cada peli o fila
            List<Pelicula> listPeli=new ArrayList<Pelicula>();
            while (rs.next()) {
                // orm: mapeo relacional objeto, lo hacen framework hibernate, jpa
                Pelicula peli=new Pelicula(rs.getInt("id"), rs.getString("titulo"), rs.getDate("anio"), rs.getDouble("puntuacion"), rs.getString("portada"));
                listPeli.add(peli);
            }         
            
            return listPeli;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
        
    }

    public Boolean add(Pelicula peli) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantInsert=st.executeUpdate("INSERT INTO peliculas (titulo, puntuacion, portada) VALUES ('"+peli.getTitulo()+"', "+peli.getPuntuacion()+", '"+peli.getPortada()+"')");
            
            Boolean insertOk=(cantInsert==1);

            return insertOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public Boolean del(Pelicula peli) {
        try {
            Statement st=ConnectorDB.getSt();
            Integer cantDel=st.executeUpdate("DELETE FROM peliculas WHERE id="+peli.getId());
            
            Boolean delOk=(cantDel==1);

            return delOk;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
