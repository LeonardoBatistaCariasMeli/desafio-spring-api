package br.com.digitalhouse.desafiospringapi.domain.entity.enums;

import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;

public enum TypeProduct {

    GAMER(1, "Gamer"),
    Standard(2, "Standard");

    private int code;
    private String description;

    TypeProduct(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TypeProduct toEnum(Integer cod) {

        if(cod == null) {
            return null;
        }

        for(TypeProduct x : TypeProduct.values()) {
            if(cod.equals(x.getCode()))
            {
                return x;
            }
        }
        throw new ObjectNotFoundException("Type not found!");
    }

}
