package com.bcopstein.ex1biblioeca;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface IAcervoRepository {
    public List<Livro> getListaLivros();

    public List<String> getListaAutores();

    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor);

    public List<Livro> getLivrosDoAutorDoAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano);

    public boolean cadastraLivroNovo(@RequestBody final Livro livro);

    public int getTotalDeLivrosDoAutor(@PathVariable(value="autor") String autor);

    public int getTotalDeLivrosDoAutorApartirDeAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano);

    public double getMediaDeLivrosPorAutor();

    public boolean emprestaLivro(int codigoLivro, int userId);
}
