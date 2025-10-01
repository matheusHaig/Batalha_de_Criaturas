package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Luz extends TipoElemental {

    public Luz(String nome) {
        super(nome, "Trevas");
        super.setStatus(EfeitoStatus.CEGAR);
    }

}
