package com.bcopstein.ex1biblioeca;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public class UsuarioRepository implements IUsuarioRepository{
    private List<Usuario> Usuarios;



    public UsuarioRepository() {
        this.Usuarios = new LinkedList<>();
        usuarios.add(new Usuario(2, "Gabriel", 2003, -1));
        usuarios.add(new Usuario(3, "João Pedro", 2005, -1));
        usuarios.add(new Usuario(4, "Bernardo Fio", 2001, -1));
        usuarios.add(new Usuario(5, "Eduardo Dudu", 1999, -1));
    }

    public List<Usuario> getListaUsuarios() {
        return usuarios;
    }

    public boolean cadastraUsuarioNovo(@RequestBody final Usuario usuario) {
        usuarios.add(usuario);
        return true;
    }


}