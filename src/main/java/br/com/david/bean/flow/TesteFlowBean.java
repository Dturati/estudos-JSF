package br.com.david.bean.flow;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped("registration")
public class TesteFlowBean implements Serializable
{
    private String nome;
    private String sobrenome;
    private String endereco;


    public void salvar()
    {
        System.out.println("Salvando no banco");
        System.out.println(this.nome);
        System.out.println(this.sobrenome);
        System.out.println(this.endereco);
//        return "ExitToInicio";
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
