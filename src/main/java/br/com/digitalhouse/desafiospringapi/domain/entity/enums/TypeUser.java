package br.com.digitalhouse.desafiospringapi.domain.entity.enums;

import br.com.digitalhouse.desafiospringapi.exceptions.ObjectNotFoundException;

public enum TypeUser {

    BUYER(1, "Buyer"),
    SELLER(2, "Seller");

    private int code;
    private String description;

    TypeUser(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static TypeUser toEnum(Integer cod) {

        if(cod == null) {
            return null;
        }

        for(TypeUser x : TypeUser.values()) {
            if(cod.equals(x.getCode()))
            {
                return x;
            }
        }
        throw new ObjectNotFoundException("Type not found!");
    }


}
