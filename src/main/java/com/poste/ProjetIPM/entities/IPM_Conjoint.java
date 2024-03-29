package com.poste.ProjetIPM.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class IPM_Conjoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idconj;
    private String nom_conjoint;
    private String prenom_conjoint;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date_naiss_conj;
    private String lieu_naiss_conj;
    public String telephone;
    @Column(nullable = true, length = 64)
    private String photos;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || idconj == null) return null;

        return "/src/main/resources/static/images/" + idconj + "/" + photos;
    }

    public Date getDate_naiss_conj() {
        return date_naiss_conj;
    }

    public void setDate_naiss_conj(Date date_naiss_conj) {
        this.date_naiss_conj = date_naiss_conj;
    }

    public String getLieu_naiss_conj() {
        return lieu_naiss_conj;
    }

    public void setLieu_naiss_conj(String lieu_naiss_conj) {
        this.lieu_naiss_conj = lieu_naiss_conj;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getIdconj() {
        return idconj;
    }

    public void setIdconj(Long idconj) {
        this.idconj = idconj;
    }

    public String getNom_conjoint() {
        return nom_conjoint;
    }

    public void setNom_conjoint(String nom_conjoint) {
        this.nom_conjoint = nom_conjoint;
    }

    public String getPrenom_conjoint() {
        return prenom_conjoint;
    }

    public void setPrenom_conjoint(String prenom_conjoint) {
        this.prenom_conjoint = prenom_conjoint;
    }

    public IPM_Employe getIpm_employe() {
        return ipm_employe;
    }

    public void setIpm_employe(IPM_Employe ipm_employe) {
        this.ipm_employe = ipm_employe;
    }


    @ManyToOne
    private IPM_Employe ipm_employe;
}
