package com.bcopstein.ex1biblioeca;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ControllerEstatisticas {
    private IAcervoRepository ACERVO;

    public ControllerEstatisticas(IAcervoRepository acervo) {
       this.ACERVO = acervo;
    }

    @GetMapping("totalivros/{autor}")
    @CrossOrigin(origins = "*")
    public int getTotalDeLivrosDoAutor(@PathVariable(value="autor") String autor) {
        return ACERVO.getTotalDeLivrosDoAutor(autor);
    }

    @GetMapping("totalivros/{autor}/ano/{ano}")
    @CrossOrigin(origins = "*")
    public int getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return ACERVO.getTotalDeLivrosDoAutorApartirDeAno(autor, ano);
    }

    @GetMapping("media")
    @CrossOrigin(origins = "*")
    public double getMediaDeLivrosPorAutor() {
        return ACERVO.getMediaDeLivrosPorAutor();
    }    
}