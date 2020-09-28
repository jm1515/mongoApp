package com.bd.projetmongo.model.entities;

public class Fields {

    private String code_postal;
    private String code_insee;
    private String nom_commune;
    private String code_departement;
    private double surface_commune_km2;
    private double population_commune;
    private String reseau;
    private String operateur;
    private String type_couverture;
    private double couverture = 0;
    private Object coordonnees[];
    private String var;
    private String var2;

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public Fields(){}

    public Fields(String code_postal, String code_insee,
                  String nom_commune, String code_departement,
                  double surface_commune_km2, double population_commune,
                  String reseau, String operateur, String type_couverture,
                  double couverture, Object[] coordonnees, String var, String var2) {
        this.code_postal = code_postal;
        this.code_insee = code_insee;
        this.nom_commune = nom_commune;
        this.code_departement = code_departement;
        this.surface_commune_km2 = surface_commune_km2;
        this.population_commune = population_commune;
        this.reseau = reseau;
        this.operateur = operateur;
        this.type_couverture = type_couverture;
        this.couverture = couverture; // 2 données comportent des couvertures qui sont vides, il faut les supprimer
        this.coordonnees = coordonnees;
        this.var = var;
        this.var2 = var2;
    }

    public Fields(String code_postal, String code_insee,
                  String nom_commune, String code_departement, double surface_commune_km2,
                  double population_commune, String reseau, String operateur, String type_couverture,
                  double couverture, String var, String var2) {
        this.code_postal = code_postal;
        this.code_insee = code_insee;
        this.nom_commune = nom_commune;
        this.code_departement = code_departement;
        this.surface_commune_km2 = surface_commune_km2;
        this.population_commune = population_commune;
        this.reseau = reseau;
        this.operateur = operateur;
        this.type_couverture = type_couverture;
        this.couverture = couverture; // 2 données comportent des couvertures qui sont vides, il faut les supprimer
        this.coordonnees = new Object[]{0.0,0.0};
        this.var = var;
        this.var2 = var2;
    }

    public Fields(String code_postal, String code_insee,
                  String nom_commune, String code_departement,
                  double surface_commune_km2, double population_commune,
                  String reseau, String operateur, String type_couverture,
                  double couverture){

        this.code_postal = code_postal;
        this.code_insee = code_insee;
        this.nom_commune = nom_commune;
        this.code_departement = code_departement;
        this.surface_commune_km2 = surface_commune_km2;
        this.population_commune = population_commune;
        this.reseau = reseau;
        this.operateur = operateur;
        this.type_couverture = type_couverture;
        this.couverture = couverture;
    }

    public Fields(String operateur, String reseau, String code_postal, String code_departement, String nom_commune){
        this.operateur = operateur;
        this.reseau = reseau;
        this.code_postal = code_postal;
        this.code_departement = code_departement;
        this.nom_commune = nom_commune;
    }



    public String getNomCommune() {
        return nom_commune;
    }

    public void setNomCommune(String nom_commune) {
        this.nom_commune = nom_commune;
    }

    public double getSurfaceCommune() {
        return surface_commune_km2;
    }

    public void setSurfaceCommune(double surface_commune_km2) {
        this.surface_commune_km2 = surface_commune_km2;
    }

    public double getPopulationCommune() {
        return population_commune;
    }

    public void setPopulationCommune(double population_commune) {
        this.population_commune = population_commune;
    }

    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public String getOperateur() {
        return this.operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getTypeCouverture() {
        return type_couverture;
    }

    public void setTypeCouverture(String type_couverture) {
        this.type_couverture = type_couverture;
    }

    public double getCouverture() {
        return couverture;
    }

    public void setCouverture(double couverture) {
        this.couverture = couverture;
    }

    public Object[] getCoordonnees() {
        return coordonnees;
    }

    public void setCoordonnees(Object[] coordonnees) {
        this.coordonnees = coordonnees;
    }

    public String getcode_insee() {

        return this.code_insee;
    }

    public void setcode_insee(String code_insee) {
        this.code_insee = code_insee;
    }

    public String getCodePostal() {
        return code_postal;
    }

    public void setCodePostal(String code_postal) {
        this.code_postal = code_postal;
    }

    public String getCodeDepartement() {
        return code_departement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.code_departement = codeDepartement;
    }

    @Override
    public String toString() {
        return "Fields : [reseau : " + this.reseau + ", code_postal : " + this.code_postal
                + ", surface_commune_km2 " + this.surface_commune_km2 + ", var2 : " + this.var2
                + ", type_couverture : " + this.type_couverture + ", couverture " + this.couverture
                + ", operateur : " + this.operateur + ", population_commune : " + this.population_commune
                + ", code_insee : " + this.code_insee + ", var : " + this.var + ", code_departement : " + this.code_departement
                + ", nom_commune : " + this.nom_commune + "]";
    }

}
