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
public class ComunicacaoTesteDoisBean implements Serializable{

    @Inject @Param(name = "nome")
    private String nome;

    @Inject @Param(name = "sobrenome")
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

    @PostConstruct
    public void init(){
        System.out.println("Post construct do Comunicao teste dois");
        Map<String, String> requestParameterMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        System.out.println(requestParameterMap.get("nome"));
        System.out.println(requestParameterMap.get("sobrenome"));
//        this.nome = requestParameterMap.get("nome");
//        this.sobrenome = requestParameterMap.get("sobrenome");
    }

    public void imprimirAtributos(){
        String initParameter = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getInitParameter("images.location");

        System.out.println(initParameter);
    }

}
