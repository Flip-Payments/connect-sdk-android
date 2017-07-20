package com.flip.connect.domain.entities;

/**
 * Created by ltorres on 20/07/2017.
 */

public enum GenderType {
    feminine(1),
    masculine(2),
    undefined(0);

    private static String[] valuesPT = {"Indefinido", "Feminino", "Masculino"};

    private final int position;

    GenderType(int position){
        this.position = position;
    }

    public static GenderType getValueFromPT(String text){
        for(int i=0;i<valuesPT.length;i++){
            if(valuesPT[i].equals(text)){
                return values()[i];
            }
        }
        return undefined;
    }

    public static int getPositionFromPT(String text){
        for(int i=0;i<valuesPT.length;i++){
            if(valuesPT[i].equals(text)){
                return i;
            }
        }
        return 0;
    }

    public static String[] getValuesPT(){
        return valuesPT;
    }
}
