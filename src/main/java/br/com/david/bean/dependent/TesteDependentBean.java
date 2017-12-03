package br.com.david.bean.dependent;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@Dependent
public class TesteDependentBean implements Serializable {
    private List<String> pessoas;
    private List<String> pessoasSelecionadas = new ArrayList<>();
    private List<String> categoriasList = new ArrayList<>();

    public List<String> getCategoriasList() {
        return categoriasList;
    }

    public void setCategoriasList(List<String> categoriasList) {
        this.categoriasList = categoriasList;
    }

    @PostConstruct
    public void init()
    {
        System.out.println("Entrou no postContruct do Dependent bean");
        this.pessoas = Arrays.asList("David","Marinete","josé");
    }

    public void selecionarPessoa()
    {
        int index = ThreadLocalRandom.current().nextInt(3);
        String pessoa = pessoas.get(index);
        pessoasSelecionadas.add(pessoa);
    }


    public List<String> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<String> pessoas) {
        this.pessoas = pessoas;
    }

    public List<String> getPessoasSelecionadas() {
        return pessoasSelecionadas;
    }

    public void setPessoasSelecionadas(List<String> pessoasSelecionadas) {
        this.pessoasSelecionadas = pessoasSelecionadas;
    }


}
