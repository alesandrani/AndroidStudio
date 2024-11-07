package com.example.apppizzeria.modelo.dao;

import com.example.apppizzeria.modelo.entidad.Usuario;

import java.util.ArrayList;

public class DaoUsuarioArray {

    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public DaoUsuarioArray(){
        listaUsuarios.add(new Usuario("Calle A,123", "Juan", "123"));
        listaUsuarios.add(new Usuario("Calle B, 456", "Maria", "123"));
        listaUsuarios.add(new Usuario("Calle C, 789", "Elena", "123"));
    }

    /**
     * Metodo que devuelve un objeto usuario por nombre si coincide dentro del array
     * @param name el nombre del usuario a buscar
     * @return usuaro si hemos encontrado el usuario en el array, null si no existe
     */
    public Usuario getByName(String name){
        for(Usuario u : listaUsuarios){
            if(u.getNombre().equals(name)){
                return u;
            }
        }
        return null;
    }

}
