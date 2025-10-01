package Itens;

import Criatura.Criatura;

public class Espada extends Item{

    private int bonusDeAtaque;

    public Espada(String nome) {
        super(nome);
        this.bonusDeAtaque = 5;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.setAtaque(criatura.getAtaque() + bonusDeAtaque);
        System.out.println(criatura.getNome() + " equipou " + getNome() +
                " e ganhou +" + bonusDeAtaque + " de ataque!");
    }
}
