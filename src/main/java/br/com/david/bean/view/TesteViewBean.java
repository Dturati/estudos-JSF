package br.com.david.bean.view;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ViewScoped
public class TesteViewBean implements Serializable
{
    private List<String> pessoas;
    private List<String> pessoasSelecionadas = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        System.out.println("Entrou no postContruct do ViewScoped");
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
