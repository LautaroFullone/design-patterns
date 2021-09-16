package org.formacion;

public class InternationalBankAdapter implements InternationalMoneyOrganization{
    private BancoNostrum banco;

    public InternationalBankAdapter(BancoNostrum bancoNostrum) {
        this.banco = bancoNostrum;
    }

    @Override
    public void transfer(int cantidad, String cliente) {
        banco.movimiento(cliente, cantidad);
    }

    @Override
    public int state(String cliente) {
        Integer state = banco.estado(cliente);
        if(state != null)
            return state;
        else
            return 0;
    }
}
