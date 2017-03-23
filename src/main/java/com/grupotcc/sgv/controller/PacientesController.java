/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.controller;

import com.grupotcc.sgv.dao.PacientesDAO;
import com.grupotcc.sgv.dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.grupotcc.sgv.model.Paciente;
import com.grupotcc.sgv.model.PerfilAcesso;
import com.grupotcc.sgv.model.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kanec
 */
public class PacientesController extends HttpServlet{

    private PacientesDAO dao;

    public PacientesController() throws SQLException {
        this.dao = new PacientesDAO();
    }
    
    public boolean inserirPaciente(Paciente p) throws SQLException {

        final JPanel panel = new JPanel();
        if (p.getNome() != null && p.getSobrenome() != null && p.getRg() != null && p.getCpf() != null
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
        if (p.getNome() != null && p.getSobrenome() != null && p.getRg() != null && p.getCpf() != null
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
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            String acao = request.getParameter("acao");
            if (acao.equals("Cadastrar")) {
                Usuario usuario = new Usuario();
                usuario.setNome(request.getParameter("txtLogin"));
                usuario.setSenha(request.getParameter("txtSenha"));
                String perfil = request.getParameter("optPerfil");
                if (perfil.equalsIgnoreCase("administrador")) {
                    usuario.setPerfil(PerfilAcesso.ADMINISTRADOR);
                } else {
                    usuario.setPerfil(PerfilAcesso.COMUM);
                }
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.cadastrarNovoUsuario(usuario);
                request.setAttribute("msg", "cadastrado com sucesso");
                RequestDispatcher rd
                        = request.getRequestDispatcher("/admin/cadastro_paciente.jsp");
                rd.forward(request, response);
            }
        } catch (Exception erro) {
            RequestDispatcher rd = request.getRequestDispatcher("/erro.jsp");
            request.setAttribute("erro", erro);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
