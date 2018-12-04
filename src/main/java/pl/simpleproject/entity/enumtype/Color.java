package pl.simpleproject.entity.enumtype;

public enum Color {
    BLACK("#000000"), WHITE("#FFFFFF"), RED("#FF0000"), GREEN("#008000"), BLUE("#0000FF"),YELLOW("#FFFF00");

    private String colorHex;

    public String getColorHex(){
        return colorHex;
    }

    Color(String colorHex) {
        this.colorHex = colorHex;
    }
}

