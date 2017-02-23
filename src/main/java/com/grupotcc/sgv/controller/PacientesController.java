/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.controller;

import com.grupotcc.sgv.dao.PacientesDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.grupotcc.sgv.model.Paciente;

/**
 *
 * @author Kanec
 */
public class PacientesController {

    private PacientesDAO dao;

    public PacientesController() throws SQLException {
        this.dao = new PacientesDAO();
    }
    
    public boolean inserirPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getNome() != null && p.getSobrenome() != null && p.getRg() != 0 && p.getCpf() != 0
                && p.getEndereco() != null && p.getEmail() != null) {
            p.setNome(p.getNome());
            p.setSobrenome(p.getSobrenome());
            p.setRg(p.getRg());
            p.setCpf(p.getCpf());
            p.setEndereco(p.getEndereco());
            p.setEmail(p.getEmail());
            dao.cadastrarNovoPaciente(p);
            JOptionPane.showMessageDialog(panel, "Paciente Cadastrado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        //('Vitor','d','d','f',1,2,'r',true,true);
        return true;
    }

    public boolean atualizarPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getNome() != null && p.getSobrenome() != null && p.getRg() != 0 && p.getCpf() != 0
                && p.getEndereco() != null && p.getEmail() != null && p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.getId();
            p.setNome(p.getNome());
            p.setSobrenome(p.getSobrenome());
            p.setRg(p.getRg());
            p.setCpf(p.getCpf());
            p.setEndereco(p.getEndereco());
            p.setEmail(p.getEmail());
            dao.atualizarPaciente(p);
            JOptionPane.showMessageDialog(panel, "Paciente Atualizado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean excluirPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.excluirPaciente(p);
            JOptionPane.showMessageDialog(panel, "Paciente Apagado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean mostrarPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.buscarPaciente(p);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean resetarSenha(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getId() == dao.selectID(p) && p.isAtivo() != dao.setAtivo(p)) {
            p.setId(p.getId());
            dao.resetarSenha(p);
            JOptionPane.showMessageDialog(panel, "Senha Resatada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }
}
