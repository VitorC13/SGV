/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.controller;

import com.grupotcc.sgv.dao.AgendamentoDAO;
import com.grupotcc.sgv.dao.PacientesDAO;
import com.grupotcc.sgv.dao.VacinasDAO;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.grupotcc.sgv.model.Agendamento;
import com.grupotcc.sgv.model.Paciente;
import com.grupotcc.sgv.model.Vacinas;

/**
 *
 * @author Kanec
 */
public class AgendamentoController {

    AgendamentoDAO dao;
    PacientesDAO daoPac;
    VacinasDAO daoVac;

    public AgendamentoController() throws SQLException {
        this.dao = new AgendamentoDAO();
        this.daoPac = new PacientesDAO();
        this.daoVac = new VacinasDAO();
    }

    public boolean inserirAgendamento(Vacinas v, Paciente p, Agendamento a) throws SQLException, ParseException {

        final JPanel panel = new JPanel();
        if (a.getDataDose() != null && v.getId() == daoVac.selectID(v)
                && v.isAtivo() != daoVac.setAtivo(v) && p.getId() == daoPac.selectID(p)
                && p.isAtivo() != daoPac.setAtivo(p)) {
            a.setDataDose(a.getDataDose());
            p.setId(p.getId());
            v.setId(v.getId());
            a.setPaciente(p);
            a.setVacinas(v);
            dao.cadastrarNovosAgendamentos(a);
            JOptionPane.showMessageDialog(panel, "Agendamento Cadastrado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean atualizarAgendamentoDia(Agendamento a) throws SQLException {

        final JPanel panel = new JPanel();
        if (a.getDataDose() != null && a.getId() == dao.selectID(a)
                && a.isAtivo() != dao.setAtivo(a)) {
            a.setDataDose(a.getDataDose());
            dao.atualizarAgendamentoDia(a);
            JOptionPane.showMessageDialog(panel, "Dia do Agendamento Atualizado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean atualizarAgendamentoVacina(Vacinas v, Agendamento a) throws SQLException {

        final JPanel panel = new JPanel();
        if (a.getDataDose() != null && a.getId() == dao.selectID(a)
                && a.isAtivo() != dao.setAtivo(a) && v.getId() == daoVac.selectID(v)
                && v.isAtivo() != daoVac.setAtivo(v)) {
            a.setDataDose(a.getDataDose());
            v.setId(v.getId());
            dao.atualizarAgendamentoVacina(v, a);
            JOptionPane.showMessageDialog(panel, "Vacina do Dia de Agendamento Atualizada", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "Inserção Incorreta de Dados", "Warning", JOptionPane.WARNING_MESSAGE);
        }

        return true;
    }

    public boolean excluirAgendamento(Agendamento a) throws SQLException {

        final JPanel panel = new JPanel();
        if (a.getId() == dao.selectID(a) && a.isAtivo() != dao.setAtivo(a)) {
            a.setId(a.getId());
            dao.excluirAgendamento(a);
            JOptionPane.showMessageDialog(panel, "Agendamento Apagado", "Warning", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }

    public boolean mostrarAgendamento(Agendamento a) throws SQLException {

        final JPanel panel = new JPanel();
        if (a.getId() == dao.selectID(a) && a.isAtivo() != dao.setAtivo(a)) {
            a.setId(a.getId());
            dao.buscarAgendamento(a);
        } else {
            JOptionPane.showMessageDialog(panel, "ID não achado", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
}
