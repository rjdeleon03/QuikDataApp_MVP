package com.icred.quikdata.Models.Base;

import io.realm.RealmModel;

public interface IEnumDataRow<T> extends RealmModel, IFieldHolder {

    T getActualType();
}
