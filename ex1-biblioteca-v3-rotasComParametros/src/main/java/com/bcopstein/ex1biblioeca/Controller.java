package com.bcopstein.ex1biblioeca;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private IAcervoRepository ACERVO;

    public Controller(IAcervoRepository acervo) {
       this.ACERVO = acervo;
    }

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public String mensagemDeBemVindo() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getListaLivros() {
        return ACERVO.getListaLivros();
    }

    @GetMapping("autores")
    @CrossOrigin(origins = "*")
    public List<String> getListaAutores() {
        return ACERVO.getListaAutores();
    }

    @GetMapping("livrosautor")// livrosautor?autor=Huguinho Pato
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return ACERVO.getLivrosDoAutor(autor);
    }

    @GetMapping("/livrosautor/{autor}/ano/{ano}") //livrosautor/Huguinho Pato/ano/2023
    @CrossOrigin(origins = "*")
    public List<Livro> getLivrosDoAutorDoAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return ACERVO.getLivrosDoAutorDoAno(autor, ano);
    }

    @PostMapping("/novolivro")
    @CrossOrigin(origins = "*")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        return ACERVO.cadastraLivroNovo(livro);
    }

    @GetMapping("emprestimos")
    @CrossOrigin(origins = "*")
    public boolean emprestaLivro(@PathVariable(value="titulo") String titulo, @PathVariable(value="autor") String autor) {
        //TODO
        return true;
    }

    @GetMapping("emprestimos")
    @CrossOrigin(origins = "*")
    public boolean devolveLivro(@PathVariable(value="titulo") String titulo, @PathVariable(value="autor") String autor) {
        //TODO
        return true;
    }

}