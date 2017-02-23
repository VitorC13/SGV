/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.model;

import static java.lang.System.out;
import com.grupotcc.sgv.conexaoBanco.ConectaBancoDeDados;
import com.grupotcc.sgv.controller.AgendamentoController;
import com.grupotcc.sgv.controller.PacientesController;
import com.grupotcc.sgv.controller.VacinasController;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 *
 * @author Kanec
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        // TODO code application logic here
        ConectaBancoDeDados.getConexaoMySQL();
        out.println(ConectaBancoDeDados.statusConection());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        PacientesController p = new PacientesController();

        Paciente pac = new Paciente();
        pac.setNome("fghbfgbf");
        pac.setSobrenome("ututeqeqweyut");
        pac.setRg(5353432);
        pac.setCpf(5346778);
        pac.setEmail("%%$$$$$");
        pac.setEndereco("fsfghhn");
        //pac.setId(3);
        p.inserirPaciente(pac);
        //p.excluirPaciente(pac);
        //p.atualizarPaciente(pac);
        //p.mostrarPaciente(pac);
        //p.resetarSenha(pac);

        VacinasController v = new VacinasController();
        Vacinas vac = new Vacinas();
        
        //Setar Date Validade
        String dataValidade = "15/02/2017";
        Date dataVali = df.parse(dataValidade);
        vac.setDataValidade(dataVali);
        
        //Setar Date Fabricacao
        String dataFabricacao = "15/02/2016";
        Date dataFabri = df.parse(dataFabricacao);
        vac.setDataFabricacao(dataFabri);
        
        vac.setNome("Aasw");
        vac.setTipo("Bfsd");
        vac.setQuantidade(14523);
        vac.setLote("0x2542942423s8");
        //vac.setId(4);
        v.inserirVacina(vac);
        //v.atualizarVacina(vac);
        //v.excluirVacina(vac);
        //v.mostrarVacina(vac);

        AgendamentoController a = new AgendamentoController();
        Agendamento ag = new Agendamento();
        
        
        /*String data = "15/02/2017";
        Date dataFinal = df.parse(data);*/
        String dataAgendamento = "15/02/2017";
        Date dataAgenda = df.parse(dataAgendamento);
        ag.setDataDose(dataAgenda);
       
        //ag.setId(3);
        a.inserirAgendamento(vac, pac, ag);
        //a.atualizarAgendamentoDia(ag);
        //a.atualizarAgendamentoVacina(vac, ag);
        //a.excluirAgendamento(ag);
        //a.mostrarAgendamento(ag);
    }

}
