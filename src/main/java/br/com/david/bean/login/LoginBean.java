package br.com.david.bean.login;

import br.com.david.model.Estudante;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable{

    private String nome;
    private String senha;
    private Estudante estudante;

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String logar(){
        System.out.println("Busca no banco");

        System.out.println(this.nome);
        System.out.println(this.senha);
        estudante = new Estudante();

        System.out.println(estudante.getCredencial());
        System.out.println(estudante.getNome());

        if(this.nome.equals(estudante.getNome()) && this.senha.equals(estudante.getCredencial())){
            System.out.println("sucesso");
            return "/restricted/iniciosistema.xhtml?faces-redirect=true";
        }

        System.out.println("Erro no login");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro de login",""));

        return null;
    }

    public String logout() {
        System.out.println("Deslogando");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.estudante = null;
        return "/login.xhtml?faces-redirect=true";
    }

}
