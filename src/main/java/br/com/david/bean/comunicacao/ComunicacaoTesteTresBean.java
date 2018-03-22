package br.com.david.bean.comunicacao;

import org.omnifaces.cdi.Param;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Named
@ViewScoped
public class ComunicacaoTesteTresBean implements Serializable{

    private String nome;
    private String sobrenome;
    private String data;
    private String data2;

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
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

//    @PostConstruct
    public void init(){

        //Não é uma requisição ajax
//        if(!FacesContext.getCurrentInstance().isPostback()){
            System.out.println("Post construct do Comunicacao tres");
            System.out.println(this.nome);
            System.out.println(this.sobrenome);
//        }


    }

    public String save(){
        System.out.println("Salvando");
        return "resultado?faces-redirect=true&amp;includeViewParams=true";
    }

    public void imprimirAtributos(){
        String initParameter = FacesContext.getCurrentInstance()
                .getExternalContext()
                .getInitParameter("images.location");

        System.out.println(initParameter);
    }

}
