package model;

/**
 *
 * @author Daniel Barrientos - 1152143
 */
public class Rifa {

    private int codigo;
    private String descripcion;

    public Rifa() {
    }

    public Rifa(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Rifa determinarPremio(int codigo) {
        Rifa rifa = null;

        switch (codigo) {
            case 1:
                rifa = new Rifa(codigo, "obsequio");
                break;
            case 2:
                rifa = new Rifa(codigo, "bono");
                break;
            default:
                throw new AssertionError();
        }

        return rifa;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
