package com.example.demo.Service;

import com.example.demo.Model.M_Pessoa;
import com.example.demo.Model.M_Resposta;
import com.example.demo.Repository.R_deposito;
import org.springframework.stereotype.Service;

@Service
public class S_Deposito {
    private static R_deposito r_deposito;

    public S_Deposito(R_deposito r_deposito) {
        this.r_deposito = r_deposito;
    }

    public static M_Resposta deposito(String valorDeposito, String dinheiro) {
        boolean despositoValido = true;
        String mensagemRetorno = "";
        valorDeposito = S_NumberCleaner.cleanerNumber(valorDeposito);
        if (valorDeposito.trim() == "") {
            mensagemRetorno += "Deve ser informado um valor para o deposito";
            despositoValido = false;
        }
        if (despositoValido) {
            M_Pessoa m_pessoa = new M_Pessoa();
            dinheiro = valorDeposito;
            m_pessoa.setDinheiro(Double.parseDouble(dinheiro));
            r_deposito.save(m_pessoa);
            mensagemRetorno += "Deu bom, agr vc tem dinheiro deixou de ser pobre!";
        }
        M_Resposta m_resposta = new M_Resposta(despositoValido,mensagemRetorno);
        return m_resposta;
    }
}
