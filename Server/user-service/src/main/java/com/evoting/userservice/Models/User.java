package com.evoting.userservice.Models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String login;

    private String psw;
    private Integer cin;
    private String nom;
    private String prenom;
    private Date date_naissance;
    private Enum role;
    private Integer tel;
    private String parti_politique;
    private Date date_engagement;
    private String occupation_actuel;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public Integer getCin() {
        return cin;
    }

    public void setCin(Integer cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public String getParti_politique() {
        return parti_politique;
    }

    public void setParti_politique(String parti_politique) {
        this.parti_politique = parti_politique;
    }

    public Date getDate_engagement() {
        return date_engagement;
    }

    public void setDate_engagement(Date date_engagement) {
        this.date_engagement = date_engagement;
    }

    public String getOccupation_actuel() {
        return occupation_actuel;
    }

    public void setOccupation_actuel(String occupation_actuel) {
        this.occupation_actuel = occupation_actuel;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", psw='" + psw + '\'' +
                ", cin=" + cin +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", date_naissance=" + date_naissance +
                ", role=" + role +
                ", tel=" + tel +
                ", parti_politique='" + parti_politique + '\'' +
                ", date_engagement=" + date_engagement +
                ", occupation_actuel='" + occupation_actuel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(login, user.login) && Objects.equals(psw, user.psw) && Objects.equals(cin, user.cin) && Objects.equals(nom, user.nom) && Objects.equals(prenom, user.prenom) && Objects.equals(date_naissance, user.date_naissance) && Objects.equals(role, user.role) && Objects.equals(tel, user.tel) && Objects.equals(parti_politique, user.parti_politique) && Objects.equals(date_engagement, user.date_engagement) && Objects.equals(occupation_actuel, user.occupation_actuel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, psw, cin, nom, prenom, date_naissance, role, tel, parti_politique, date_engagement, occupation_actuel);
    }
}
