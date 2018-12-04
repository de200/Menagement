package pl.simpleproject.entity.enumtype;

public enum Separators {
    SEPARATOR("#"), PRODUCT_ID("P"), BOOTS_ID("B"), CLOTH_ID("C");

    private String description;

    public String getDescription(){
        return description;
    }

    Separators(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

    public static Separators getIdByChar(String word){
        for(Separators description : Separators.values()){
            if(description.equals(word)){
                return description;
            }
        }
        return null;
    }
}
