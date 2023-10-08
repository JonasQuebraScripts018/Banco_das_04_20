package com.example.demo.Service;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Repository.R_transacao;
import org.springframework.stereotype.Service;

@Service
public class S_Transacao {
    public static R_transacao r_transacao;

    public S_Transacao(R_transacao r_transacao) {
        this.r_transacao = r_transacao;
    }

    public static M_Resposta trasacao(Long dinheiro, Long valorTransacao){
        boolean transacaoValida = true;
        String mensagemRetorno = "";
        if(dinheiro == null){
            transacaoValida = false;
            mensagemRetorno += "Você não tem dinheiro! Seu pobre fudido";
        }
        if(dinheiro < valorTransacao){
            transacaoValida = false;
            mensagemRetorno += "Você não tem dinheiro soficiente para realizar esse transação! " +
                    "Seu pobre, deposite para realizar a Transação";
        }
        if(transacaoValida){
            M_Pessoa m_pessoa = new M_Pessoa();
            Long result = dinheiro - valorTransacao;
            dinheiro = result;
            m_pessoa.setDinheiro(dinheiro);
            r_transacao.save(m_pessoa);
        }
        M_Resposta m_resposta = new M_Resposta(transacaoValida, mensagemRetorno);
        return m_resposta;
    }
}
