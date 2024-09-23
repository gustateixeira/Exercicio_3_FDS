package com.bcopstein.ex1biblioeca;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IUsuarioRepository{
    public List<Usuario> getListaUsuarios();

    public boolean cadastraUsuarioNovo(@RequestBody final Usuario usuario);


}