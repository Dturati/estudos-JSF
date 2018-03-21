package br.com.david.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTesteTresBean implements Serializable{

    private String nome;
    private String sobrenome;

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

//    @PostConstruct
    public void init(){
        System.out.println("Post construct do Comunicao tres");
        System.out.println(this.nome);
        System.out.println(this.sobrenome);

    }

    public void imprimirAtributos(){
        String initParameter = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getInitParameter("images.location");

        System.out.println(initParameter);
    }

}
