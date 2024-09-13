package com.bcopstein.ex1biblioeca;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class Acervo {
    private List<Livro> livros;

    public Acervo(List<Livro> livros) {
        this.livros = new LinkedList<>();
        livros.add(new Livro(100, "Aprendendo Spring-Boot", "Huguinho Pato", 2020));
        livros.add(new Livro(120, "Aprendendo Java", "Zezinho Pato", 2015));
        livros.add(new Livro(140, "Aprendendo Outra coisa", "Luizinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Uma coisa nova", "Huguinho Pato", 2023));
        livros.add(new Livro(140, "Aprendendo Outra coisa nova", "Huguinho Pato", 2023));
    }

    public List<Livro> getListaLivros() {
        return livros;
    }

    public List<String> getListaAutores() {
        return livros.stream()
                .map(l -> l.getAutor())
                .toList();
    }

    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList();
    }

    public List<Livro> getLivrosDoAutor(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .filter(livro -> livro.getAno() == ano)
                .toList();
    }

    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
        livros.add(livro);
        return true;
    }

    public int getTotalDeLivrosDoAutor(@PathVariable(value="autor") String autor) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .toList().size();
    }

    public int getTotalDeLivrosDoAutorApartirDeAno(@PathVariable(value="autor") String autor, @PathVariable(value="ano")int ano) {
        return livros.stream()
                .filter(livro -> livro.getAutor().equals(autor))
                .filter(livro -> livro.getAno() >= ano)
                .toList().size();
    }

    public double getMediaDeLivrosPorAutor() {
        int totalLivros = getListaLivros().size();
        int totalAutores = getListaAutores().size();
        return totalLivros / totalAutores;
    }
}
