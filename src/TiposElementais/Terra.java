package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Terra extends TipoElemental {

    public Terra(String nome) {
        super(nome, "Ar");
        super.setStatus(EfeitoStatus.PARALISAR);
    }

}
