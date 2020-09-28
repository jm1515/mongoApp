package com.bd.projetmongo.model.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="data")
public class Data {

    @Id
    private ObjectId _id;

    private Fields fields;
    private String datasetid;
    private String recordid;
    private Geometry geometry;

    public Data(Fields fields){
        this.fields = fields;
    }

    public Data(){}

    public Data(ObjectId _id, String recordid, Fields fields, Geometry geometry){
        this._id = _id;
        this.datasetid = "couverture-2g-3g-4g-en-france-par-operateur-juillet-2015";
        this.recordid = recordid;
        this.fields = fields;
        this.geometry = geometry;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    @Override
    public String toString() {
        return "Data : [ " + this.fields.toString() + ", " + this.geometry.toString() + " ]";
    }
}
