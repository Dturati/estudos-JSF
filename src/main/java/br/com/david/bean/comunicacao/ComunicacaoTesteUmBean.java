package br.com.david.bean.comunicacao;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class ComunicacaoTesteUmBean implements Serializable{

    private String nome;
    private String sobrenome;
    private Date data = new Date();
    private Date data2 = new Date();

    public Date getData2() {
        return data2;
    }

    public void setData2(Date data2) {
        this.data2 = data2;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

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
