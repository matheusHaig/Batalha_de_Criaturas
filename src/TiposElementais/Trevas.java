package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Trevas extends TipoElemental {

    public Trevas(String nome) {
        super(nome, "Fogo");
        super.setStatus(EfeitoStatus.DORMIR);
    }
}
