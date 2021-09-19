package model;

public class ItemPedido {
    int codPedido, codItem;

    public ItemPedido(){}

    public ItemPedido(int codPedido, int codItem) {
        this.codPedido = codPedido;
        this.codItem = codItem;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public int getCodItem() {
        return codItem;
    }

    public void setCodItem(int codItem) {
        this.codItem = codItem;
    }
}
