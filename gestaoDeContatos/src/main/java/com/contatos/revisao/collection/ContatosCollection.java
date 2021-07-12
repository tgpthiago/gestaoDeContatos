package com.contatos.revisao.collection;

import com.contatos.revisao.model.Contato;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tgp
 */
public class ContatosCollection {
    private ArrayList<Contato> contatos;

    public ContatosCollection() {
        contatos = new ArrayList<>();
    }
    
    public void add(Contato contato){
        if (contatos.contains(contato)){
            throw new RuntimeException("Contato Já existe");
        }
        if (contato != null){
            contatos.add(contato);
        }else{
            throw new RuntimeException("Forneça uma Instância de um contato");
        }
    }
    public List<Contato> getContatos(){
        return Collections.unmodifiableList(contatos);
    }
}


