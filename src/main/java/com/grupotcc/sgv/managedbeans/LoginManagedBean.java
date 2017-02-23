/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.managedbeans;

import com.grupotcc.sgv.dao.PacientesDAO;
import com.grupotcc.sgv.model.Paciente;
import java.sql.SQLException;
//import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author vitor
 */
@ManagedBean(name="Login")
@ViewScoped
public class LoginManagedBean {

    private PacientesDAO pacienteDAO;
    private Paciente paciente = new Paciente();

    public LoginManagedBean() throws SQLException {
        this.pacienteDAO = new PacientesDAO();
    }

    public String envia() {

        paciente = pacienteDAO.getPaciente(paciente.getNome(), paciente.getSenha());
        if (paciente == null) {
            paciente = new Paciente();
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!",
                            "Erro no Login!"));
            return null;
        } else {
            return "/main";
        }

    }

    public Paciente getUsuario() {
        return paciente;
    }

    public void setPaciente(Paciente usuario) {
        this.paciente = usuario;
    }
}
