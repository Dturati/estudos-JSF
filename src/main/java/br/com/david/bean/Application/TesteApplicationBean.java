package br.com.david.bean.Application;

import br.com.david.bean.dependent.TesteDependentBean;
import br.com.david.bean.session.TesteSessionBean;
import br.com.david.model.Estudante;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable
{
    private List<String> categoriaList;

    private final TesteDependentBean dependentBean;
    private final TesteSessionBean sessionBean;


    public TesteSessionBean getSessionBean() {
        return sessionBean;
    }

    public TesteDependentBean getDependentBean() {
        return dependentBean;
    }

    @Inject
    public TesteApplicationBean(TesteDependentBean dependentBean,TesteSessionBean sessionBean) {
        this.dependentBean = dependentBean;
        this.sessionBean = sessionBean;
    }


    @PostConstruct
    public void init()
    {
        System.out.println("Entrou no PostConstruct do TesteApplicationBean");
        this.categoriaList = Arrays.asList("Rpg","sci-fi","terror");
        dependentBean.getCategoriasList().addAll(Arrays.asList("Comédia","drama"));
        sessionBean.selecionarPessoa();
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
