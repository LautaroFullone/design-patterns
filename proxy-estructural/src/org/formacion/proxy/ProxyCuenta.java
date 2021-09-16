package org.formacion.proxy;

public class ProxyCuenta implements Cuenta{

    private CuentaNormal cuentaNormal;

    public ProxyCuenta(String nombre) {
        this.cuentaNormal = new CuentaNormal(nombre);
    }

    @Override
    public String getCliente() {
        return cuentaNormal.getCliente();
    }

    @Override
    public int getCantidad() {
        return cuentaNormal.getCantidad();
    }

    @Override
    public void movimiento(int importe) {

            if((importe + this.getCantidad()) >=0 ){
                cuentaNormal.movimiento( (getCantidad()+importe) );
            }



    }
}
