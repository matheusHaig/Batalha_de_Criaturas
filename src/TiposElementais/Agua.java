package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Agua extends TipoElemental {

    public Agua(String nome) {
        super(nome, "Terra");
        super.setStatus(EfeitoStatus.CONGELAR);
    }


}
