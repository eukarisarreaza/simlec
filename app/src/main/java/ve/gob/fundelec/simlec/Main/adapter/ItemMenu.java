package ve.gob.fundelec.simlec.Main.adapter;

/**
 * Created by root on 11/04/17.
 */

public class ItemMenu {
    private int imagen;
    private int color;
    private String texto;

    public ItemMenu(int imagen, int color, String texto) {
        this.imagen = imagen;
        this.color = color;
        this.texto = texto;
    }

    public int getImagen() {
        return imagen;
    }

    public int getColor() {
        return color;
    }

    public String getTexto() {
        return texto;
    }


}
