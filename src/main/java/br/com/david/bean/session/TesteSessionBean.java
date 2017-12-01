package br.com.david.bean.session;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable
{
    private List<String> pessoas;
    private List<String> pessoasSelecionadas = new ArrayList<>();

    @PostConstruct
    public void init()
    {
        System.out.println("Entrou no postContruct do SessionScoped");
        this.pessoas = Arrays.asList("David","Marinete","josé");
    }

    public void selecionarPessoa()
    {
        int index = ThreadLocalRandom.current().nextInt(3);
        String pessoa = pessoas.get(index);
        pessoasSelecionadas.add(pessoa);
    }

    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
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
