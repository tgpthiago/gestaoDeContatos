package com.contatos.revisao.presenter;
import com.contatos.revisao.collection.ContatosCollection;
import com.contatos.revisao.model.Contato;
import com.contatos.revisão.view.incluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author tgp
 */
public class incluirContatoPresenter {
    
    private incluirContatoView view;
    private ContatosCollection contatos;
  
    
    public incluirContatoPresenter(ContatosCollection contatos){
        this.contatos = contatos;
        view = new incluirContatoView();
        
        view.getBtnFechar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               fechar(); 
            }
            
        });
        
        view.getBtnSalvar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
            
        });
        
        view.setVisible(true);
    }
    
    private void fechar(){
        view.dispose();
    }
    
    private void salvar(){
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        
        JOptionPane.showMessageDialog(view, 
                "contato " + contato.getNome() + " salvo com sucesso!",
                "Salvo com sucesso", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
