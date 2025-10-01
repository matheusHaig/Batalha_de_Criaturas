package Criatura;

import EfeitoStatus.EfeitoStatus;
import Itens.Item;
import TiposElementais.TipoElemental;

import java.util.ArrayList;
import java.util.List;

public class Criatura implements HabilidadeEspecial {

    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int velocidade;
    private List<Item> inventario = new ArrayList<>();
    private TipoElemental tipo;
    private EfeitoStatus efeitoInimigo;

    public Criatura(String nome, int vida, int ataque, int defesa, int velocidade, TipoElemental tipo) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
        this.tipo = tipo;
        this.efeitoInimigo = EfeitoStatus.DEFAULT;
    }

    public EfeitoStatus getEfeitoInimigo() {
        return efeitoInimigo;
    }

    public void setEfeitoInimigo(EfeitoStatus efeitoInimigo) {
        this.efeitoInimigo = efeitoInimigo;
    }

    public void adicionarItem(Item item) {
        inventario.add(item);
    }

    public List<Item> getInventario() {
        return inventario;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        if(vida < 0){
            this.vida = 0;
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public TipoElemental getTipo() {
        return tipo;
    }

    @Override
    public int ataquePadrao() {
        return this.ataque;
    }

    @Override
    public EfeitoStatus ataqueStatus() {
        return this.tipo.getStatus();
    }

    @Override
    public int ataqueEspecial() {
        ataqueStatus();
        return (int) (this.ataque * 1.5);
    }

    public String listarInventario() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < inventario.size(); i++) {
            Item item = inventario.get(i);
            String statusItem = item.isUsado() ? "(usado)" : "";
            sb.append((i+1) + " - " + item.getNome() + " " + statusItem + "\n");
        }
        return sb.toString();
    }
}
