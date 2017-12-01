package br.com.david.bean.Application;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable
{
    private List<String> categoriaList;

    @PostConstruct
    public void init()
    {
        System.out.println("Entrou no PostConstruct do TesteApplicationBean");
        this.categoriaList = Arrays.asList("Rpg","sci-fi","terro");

    }

    public void mudarLista()
    {
        this.categoriaList = Arrays.asList("Rpg","sci-fi","terro","comédia");
    }

    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }

}
