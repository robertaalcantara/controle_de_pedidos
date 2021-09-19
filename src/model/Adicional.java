package model;

public class Adicional {
    int codItem, codItemAdicional;

    public Adicional(){}

    public Adicional(int codItem, int codItemAdicional) {
        this.codItem = codItem;
        this.codItemAdicional = codItemAdicional;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCodItemAdicional() {
        return codItemAdicional;
    }

    public void setCodItemAdicional(int codItemAdicional) {
        this.codItemAdicional = codItemAdicional;
    }
}
