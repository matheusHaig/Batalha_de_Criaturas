package Itens;

import Criatura.Criatura;

public class Botas extends Item{

    private int bonusDeVelocidade;

    public Botas(String nome) {
        super(nome);
        this.bonusDeVelocidade = 5;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.setVelocidade(criatura.getVelocidade() + bonusDeVelocidade);
        System.out.println(criatura.getNome() + " equipou " + getNome() +
                " e ganhou +" + bonusDeVelocidade + " de velocidade!");
    }
}
