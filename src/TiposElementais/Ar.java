package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Ar extends TipoElemental {

    public Ar(String nome) {
        super(nome, "Luz");
        super.setStatus(EfeitoStatus.SANGRAR);
    }


}
