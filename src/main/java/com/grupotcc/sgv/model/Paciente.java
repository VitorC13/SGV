/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupotcc.sgv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Kanec
 */
@Entity
public class Paciente {

    @Id
    @Column(name="id" , nullable=false, unique=true)
    private int id;
    @Column(name="nome", nullable=false, unique=true)
    private String nome;
    @Column(name="sobrenome", nullable=false, unique=true)
    private String sobrenome;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="senha", nullable=false, unique=false)
    private String senha;
    @Column(name="rg", nullable=false, unique=true)
    private int rg;
    @Column(name="cpf", nullable=false, unique=true)
    private int cpf;
    @Column(name="endereco", nullable=false, unique=true)
    private String endereco;
    @Column(name="ativo", nullable=false, unique=false)
    private boolean ativo;

    public Paciente(String nome, String sobrenome, String email,
            String senha, int rg, int cpf, String endereco, boolean ativo) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.rg = rg;
        this.cpf = cpf;
        this.endereco = endereco;
        this.ativo = ativo;
    }

    public Paciente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
