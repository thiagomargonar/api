package com.vcx.api.entity.enuns;

import java.io.Serializable;

public enum TypeEnum implements Serializable {

    TAKER("tomador"),
    PROVIDER("prestador");

    String name;

    TypeEnum(String name) {
        this.name = name;
    }

}
