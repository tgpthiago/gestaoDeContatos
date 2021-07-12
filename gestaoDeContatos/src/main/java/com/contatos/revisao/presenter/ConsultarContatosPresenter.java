
package com.contatos.revisao.presenter;

import com.contatos.revisao.collection.ContatosCollection;
import com.contatos.revisao.model.Contato;
import com.contatos.revisão.view.ConsultarContatosView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ListIterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tgp
 */
public class ConsultarContatosPresenter {
    
    private ConsultarContatosView view;
    private ContatosCollection contatos;
    private DefaultTableModel tmContatos;

    public ConsultarContatosPresenter(ContatosCollection contatos) {
        this.contatos = contatos;
        
        view = new ConsultarContatosView();
        
        tmContatos = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome" , "Telefone"}
        );
        
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while (it.hasNext()){
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(),contato.getTelefone()});
        }
        
        view.getTblContatos().setModel(tmContatos);
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
            
        });
        
        view.setVisible(true);
    }
   

    private void fechar(){
        view.dispose();
    }
    
    
}
