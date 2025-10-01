package Itens;

import Criatura.Criatura;

public class Pocao extends Item{

    private int bonusDeVida;

    public Pocao(String nome) {
        super(nome);
        this.bonusDeVida = 5;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.setVida(criatura.getVida() + bonusDeVida);
        System.out.println(criatura.getNome() + " equipou " + getNome() +
                " e ganhou +" + bonusDeVida + " de vida!");
    }
}
