package br.com.david.bean.conversation;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Named
@ConversationScoped
//Transient
public class TesteConversationBean implements Serializable
{
    private List<String> pessoas;
    private List<String> pessoasSelecionadas = new ArrayList<>();

    @Inject
    private Conversation conversation;

    //@PostConstruct
    public void init()
    {
        System.out.println("Entrou no postContruct do ConversationScoped");
        this.pessoas = Arrays.asList("David","Marinete","josé");

        if(conversation.isTransient()) {
            //Long running
            conversation.begin();
            System.out.println("iniciando conversation scoped,ID="+conversation.getId());
        }

    }

    public String endoConversation()
    {
        if(!conversation.isTransient()) {
            conversation.end();
        }

        return "conversation?faces-redirect=true";
    }

    public void selecionarPessoa()
    {
        int index = ThreadLocalRandom.current().nextInt(3);
        String pessoa = pessoas.get(index);
        pessoasSelecionadas.add(pessoa);
    }

    public String logout()
    {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "session?faces-redirect=true";
    }

    public List<String> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<String> pessoas) {
        this.pessoas = pessoas;
    }

    public List<String> getPessoasSelecionadas() {
        return pessoasSelecionadas;
    }

    public void setPessoasSelecionadas(List<String> pessoasSelecionadas) {
        this.pessoasSelecionadas = pessoasSelecionadas;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
