package br.com.david.bean.flow;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@FlowScoped(value = "pendencies")
public class TesteFlowNestedBean implements Serializable
{
    private String username;
    private String userSurname;

    public String validarUsuario()
    {
        System.out.println("Fazendo consulta no serasa");
        System.out.println("Fazendo consulta no spc");
        System.out.println("Pedindo permissão de Deus");
        System.out.println("Sacrificando um bode");

        if(true){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuário não passou nas pendendias","Detalhes"));
            return null;
        }
        return "proceedToRegistration3";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
}
