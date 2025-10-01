package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public class Fogo extends TipoElemental {
    public Fogo(String nome) {
        super(nome, "Agua");
        super.setStatus(EfeitoStatus.QUEIMAR);
    }
}
