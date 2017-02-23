/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.controller;

import com.grupotcc.sgv.dao.PacientesDAO;
import com.grupotcc.sgv.dao.VacinasDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.grupotcc.sgv.model.Paciente;
import com.grupotcc.sgv.model.Vacinas;

/**
 *
 * @author Kanec
 */
public class VacinasController {

    VacinasDAO dao;

    public VacinasController() throws SQLException {
        this.dao = new VacinasDAO();
    }
    
    public boolean inserirVacina(Vacinas v) throws SQLException, ParseException {

        
        final JPanel panel = new JPanel();
        if (v.getDataValidade() != null && v.getDataFabricacao() != null && v.getNome() != null
                && v.getTipo() != null && v.getQuantidade() != 0 && v.getLote() != null) {
            v.setDataValidade(v.getDataValidade());
            v.setDataFabricacao(v.getDataFabricacao());
            v.setNome(v.getNome());
            v.setTipo(v.getTipo());
            v.setQuantidade(v.getQuantidade());
            v.setLote(v.getLote());
            dao.cadastrarNovasVacinas(v);
            JOptionPane.showMessageDialog(panel, "Vacina Cadastrada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean atualizarVacina(Vacinas v) throws SQLException {

        final JPanel panel = new JPanel();
        if (v.getDataValidade() != null && v.getDataFabricacao() != null && v.getNome() != null
                && v.getTipo() != null && v.getQuantidade() != 0 && v.getLote() != null && v.getId() == dao.selectID(v) && v.isAtivo() != dao.setAtivo(v)) {
            v.getId();
            v.setDataValidade(v.getDataValidade());
            v.setDataFabricacao(v.getDataFabricacao());
            v.setNome(v.getNome());
            v.setTipo(v.getTipo());
            v.setQuantidade(v.getQuantidade());
            v.setLote(v.getLote());
            dao.atualizarVacinas(v);
            JOptionPane.showMessageDialog(panel, "Vacina Atualizada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        //('Vitor','d','d','f',1,2,'r',true,true);
        return true;
    }

    public boolean excluirVacina(Vacinas v) throws SQLException {

        final JPanel panel = new JPanel();
        if (v.getId() == dao.selectID(v) && v.isAtivo() != dao.setAtivo(v)) {
            v.setId(v.getId());
            dao.excluirVacinas(v);
            JOptionPane.showMessageDialog(panel, "Vacina Apagada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean mostrarVacina(Vacinas v) throws SQLException {

        final JPanel panel = new JPanel();
        if (v.getId() == dao.selectID(v) && v.isAtivo() != dao.setAtivo(v)) {
            v.setId(v.getId());
            dao.buscarVacinas(v);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

}
