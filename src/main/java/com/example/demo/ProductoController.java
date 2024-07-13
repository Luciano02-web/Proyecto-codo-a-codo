package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductoDAO;
import com.example.demo.model.Producto;

@RestController
public class ProductoController {

    @CrossOrigin(origins = "*")
    @GetMapping("/listarProductos")
    public List<Producto> listarProductos() {
        ProductoDAO productoDAO=new ProductoDAO();
        return productoDAO.listar();
    }
    
}
