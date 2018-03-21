package br.com.david.bean.comunicacao;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoTesteUmBean implements Serializable{

    private String nome;
    private String sobrenome;

    @PostConstruct
    public void init(){
        System.out.println("Entrou no @PostConstruct do ComunicacaoTesteUmBean");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void imprimirAtributos(){
        String initParameter = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getInitParameter("images.location");
        System.out.println(initParameter);
    }


    public String save(){
        System.out.println(this.nome);
        System.out.println(this.sobrenome);
        return "comunicacaoDois?faces-redirect=true&nome="+nome+"&sobrenome="+sobrenome;
    }

}
