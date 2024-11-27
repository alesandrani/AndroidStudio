package com.example.apppizzeria.modelo.negocio;

import com.example.apppizzeria.modelo.dao.DaoUsuarioArray;
import com.example.apppizzeria.modelo.entidad.Pizza;
import com.example.apppizzeria.modelo.entidad.Usuario;

import java.util.List;

public class GestorUsuario {
    private DaoUsuarioArray dua;

    /**
     * Método que valida un usuario en base a su nombre y su password. Ambos campos
     * deben de coincidir con los campos de el array list
     * @param usuario el usuario que queremos validar
     * @return usuario en caso de que el usuario exista y su password coincida, null
     * en caso de que el usuario no exista o no sea valido su password
     */
    public Usuario validar(Usuario usuario){
        dua = DaoUsuarioArray.getInstance();
        Usuario usuarioArray = dua.getByName(usuario.getNombre());
        if(usuarioArray != null){
            if(usuario.getPassword().equals(usuarioArray.getPassword())){
                return usuarioArray;
            }
        }
        return null;
    }

    /**
     * Método para registrar un nuevo usuario.
     *
     * @param usuario Usuario a registrar
     * @return true si el usuario se registró correctamente, false si ya existe
     */
    public boolean registrar(Usuario usuario) {
        dua = DaoUsuarioArray.getInstance();
        return dua.addUsuario(usuario);
    }

}

