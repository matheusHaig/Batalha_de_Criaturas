package Itens;

import Criatura.Criatura;

public class Armadura extends Item{

    private int bonusDeDefesa;

    public Armadura(String nome) {
        super(nome);
        this.bonusDeDefesa = 5;
    }

    @Override
    public void aplicar(Criatura criatura) {
        criatura.setDefesa(criatura.getDefesa() + bonusDeDefesa);
        System.out.println(criatura.getNome() + " equipou " + getNome() +
                " e ganhou +" + bonusDeDefesa + " de defesa!");
    }
}
