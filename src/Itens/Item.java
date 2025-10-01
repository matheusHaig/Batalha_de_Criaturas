package Itens;


import Criatura.Criatura;

public abstract class Item {
    private String nome;
    private boolean usado = false;

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public void usar(Criatura criatura) {
        if (!usado) {
            aplicar(criatura);
            this.usado = true;
        } else {
            System.out.println( criatura.getNome() + " já usou " + getNome() + " e não pode usar novamente!");
        }
    }

    public abstract void aplicar(Criatura criatura);
}
