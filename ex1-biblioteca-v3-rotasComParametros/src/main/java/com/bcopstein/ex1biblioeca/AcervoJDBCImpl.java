package com.bcopstein.ex1biblioeca;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    public AcervoJDBCImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Livro> getListaLivros() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros",
                           (rs, rowNum) -> new Livro(rs.getInt("codigo"),
                            rs.getString("titulo"), 
                            rs.getString("autor"), 
                            rs.getInt("ano")));
        return resp;
    }

    public List<String> getListaAutores() {
        List<String> resp = this.jdbcTemplate.query("SELECT autor from livros", (rs, rowNum) -> rs.getString("autor"));
        return resp;
    }

    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros WHERE autor ='"+autor+"'",
         (rs,rowNum) -> new Livro(rs.getInt("codigo"),
          rs.getString("titulo"),
          rs.getString("autor"),
          rs.getInt("ano")));
        return resp;
    }

    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros WHERE autor ='"+autor+"' and ano ='"+ano+"'",
         (rs,rowNum) -> new Livro(rs.getInt("codigo"),
          rs.getString("titulo"),
          rs.getString("autor"),
          rs.getInt("ano")));
        return resp;
    }

    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        var resp = this.jdbcTemplate.query("SELECT * from livros WHERE codigo ='"+livro.getId()+"'",
        (rs,rowNum) -> rs.getInt("codigo"));
        if(resp.isEmpty()){
            String query =  "INSERT INTO livros (codigo, titulo, autor, ano) VALUES(?, ?, ?, ?)";
            this.jdbcTemplate.update(query, livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getAno());
            return true;
        }
        return false;
    }   

    public int getTotalDeLivrosDoAutor(@PathVariable(value="autor") String autor) {
        var resp = this.jdbcTemplate.query("SELECT COUNT(*) from livros WHERE autor ='"+autor+"'", (rs, rowNum) -> rs.getInt("Numero de Livros"));
        return resp.get(0);
    }

    public int getTotalDeLivrosDoAutorApartirDeAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return -1;
    }

    public double getMediaDeLivrosPorAutor() {
        int totalLivros = getListaLivros().size();
        int totalAutores = getListaAutores().size();
        return totalLivros / totalAutores;
    }
}
