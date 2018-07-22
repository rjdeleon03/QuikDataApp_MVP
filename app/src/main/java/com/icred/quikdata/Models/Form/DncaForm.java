package com.icred.quikdata.Models.Form;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class DncaForm extends RealmObject {

    @Required
    @PrimaryKey
    private String id;

//    private FormDetails formDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public FormDetails getFormDetails() {
//        return formDetails;
//    }
//
//    public void setFormDetails(FormDetails formDetails) {
//        this.formDetails = formDetails;
//    }
}
