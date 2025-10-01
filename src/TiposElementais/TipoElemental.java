package TiposElementais;

import EfeitoStatus.EfeitoStatus;

public abstract class TipoElemental {

    private String nome;
    private String fraqueza;
    private EfeitoStatus status;

    public TipoElemental(String nome, String fraqueza) {
        this.nome = nome;
        this.fraqueza = fraqueza;
    }

    public String getNome() {
        return nome;
    }

    public String getFraqueza() {
        return fraqueza;
    }

    public EfeitoStatus getStatus() {
        return status;
    }

    public void setStatus(EfeitoStatus status) {
        this.status = status;
    }
}
