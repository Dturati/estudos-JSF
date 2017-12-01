package br.com.david.bean.estudante;

import br.com.david.model.Estudante;

import javax.el.LambdaExpression;
import javax.faces.component.FacesComponent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.faces.view.facelets.FaceletContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

@Named("Estudante")
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {

    private Estudante estudante = new Estudante();
    private List<String> nomesList = Arrays.asList("David","José","Maria","Gleyce");
    private Set<String> nomeSet = new HashSet<>(Arrays.asList("David","José","Maria","Gleyce")) ;
    private Map<String,String> nomesMap = new HashMap<>();
    private boolean mostrarNota = false;
    private boolean exibirLink = false;

    public boolean isMostrarNota() {
        return mostrarNota;
    }

    public String exibirNotas()
    {
       this.mostrarNota = true;
       return "index";
    }

    public String mostraLink()
    {
        this.exibirLink = true;
        return "index";
    }

    public long calcularCubo(LambdaExpression le,  long value)
    {
        long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(),value);
        System.out.println(result);
        return result;
    }

    public void setMostrarNota(boolean mostrarNota) {
        this.mostrarNota = mostrarNota;
    }

    {
        nomesMap.put("David","Lindo");
        nomesMap.put("Gleyce","Melhor buceta");
    }

    public void executar()
    {
        System.out.println("Busca no banco de dados");
        System.out.println("Processando os dados");
        System.out.println("Exibindo os dados");
    }

    public String index2(String index)
    {
        return index;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public Set<String> getNomeSet() {
        return nomeSet;
    }

    public void setNomeSet(Set<String> nomeSet) {
        this.nomeSet = nomeSet;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }


    public boolean isExibirLink() {
        return exibirLink;
    }

    public void setExibirLink(boolean exibirLink) {
        this.exibirLink = exibirLink;
    }
}
