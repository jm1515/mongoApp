package com.bd.projetmongo.model.entities;

public class SearchCriteria {
    private String codePostal;
    private String nomCommune;
    private String codeDepartement;
    private String reseau;
    private String operateur;

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNomCommune() {
        return nomCommune;
    }

    public void setNomCommune(String nomCommune) {
        this.nomCommune = nomCommune;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String toString(){
        return "[codePostal : " + this.codePostal + ", nomCommune : " + this.nomCommune + ", codeDepartement : " +
                this.codeDepartement + ", reseau : " + this.reseau + ", operateur : " + this.operateur + "]";
    }
}
