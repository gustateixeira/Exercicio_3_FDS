package com.bcopstein.ex1biblioeca;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@Repository
@Primary
public class AcervoJDBCImpl implements IAcervoRepository {
    private JdbcTemplate jdbcTemplate;
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livro> getListaLivros() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros",
                           (rs, nowNum) -> new Livro(rs.getInt("codigo"),
                            rs.getString("titulo"), 
                            rs.getString("autor"), 
                            rs.getInt("ano")));
        return resp;
    }

    public List<String> getListaAutores() {
        return null;}

    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return null;
    }

    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return null;
    }

    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return false;
    }

    public int getTotalDeLivrosDoAutor(@PathVariable(value="autor") String autor) {
        return 0;}

    public int getTotalDeLivrosDoAutorApartirDeAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return -1;
    }

    public double getMediaDeLivrosPorAutor() {
        int totalLivros = getListaLivros().size();
        int totalAutores = getListaAutores().size();
        return totalLivros / totalAutores;
    }
}
