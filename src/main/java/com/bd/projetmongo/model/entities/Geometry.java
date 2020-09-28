package com.bd.projetmongo.model.entities;

public class Geometry {

    private String type;
    private Object coordinate[];

    public Geometry(){
        this.type = "Point";
        this.coordinate = new Object[]{0.0,0.0};
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object[] getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Object[] coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() {
        return "Geometry : [ type : " + this.type + " ]" ;
    }

}
