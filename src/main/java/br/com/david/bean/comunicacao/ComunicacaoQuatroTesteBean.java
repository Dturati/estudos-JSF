package br.com.david.bean.comunicacao;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class ComunicacaoQuatroTesteBean implements Serializable{

    private String buttonName = "Nome do botão do View";

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public void execute(){
        System.out.println("Execute");
    }

}
