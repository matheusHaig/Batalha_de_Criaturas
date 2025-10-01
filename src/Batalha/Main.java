package Batalha;

import Criatura.Criatura;
import EfeitoStatus.EfeitoStatus;
import Itens.*;
import TiposElementais.Agua;
import TiposElementais.Fogo;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fogo tipoFogo = new Fogo("Fogo");
        Agua tipoAgua = new Agua("Agua");

        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipoFogo);
        Criatura c2 = new Criatura("Aqua", 100, 18, 12, 12, tipoAgua);


        c1.adicionarItem(new Espada("espada de fogo"));
        c1.adicionarItem(new Armadura("armadura de metal"));
        c1.adicionarItem(new Botas("botas de velocidade"));
        c1.adicionarItem(new Pocao("pocao de cura"));

        c2.adicionarItem(new Espada("espada de agua"));
        c2.adicionarItem(new Armadura("armadura de cobre"));
        c2.adicionarItem(new Botas("botas de velocidade"));
        c2.adicionarItem(new Pocao("pocao de cura"));

        System.out.println("Batalha iniciada: " + c1.getNome() + " vs " + c2.getNome());

       executarBatalha(c1, c2, sc);
    }

    public static Criatura executarBatalha(Criatura c1, Criatura c2, Scanner sc) {
        Criatura primeiro = determinarPrimeiroAtacante(c1, c2);
        Criatura segundo = (primeiro == c1) ? c2 : c1;

        while (primeiro.getVida() > 0 && segundo.getVida() > 0) {

            turno(primeiro, segundo, sc);
            if (segundo.getVida() <= 0) break;
            turno(segundo, primeiro, sc);

            // Mostrar status
            System.out.println("\nStatus atual:");
            System.out.println(primeiro.getNome() + ": " + primeiro.getVida() + " HP");
            System.out.println(segundo.getNome() + ": " + segundo.getVida() + " HP\n");
        }

        // Mostrar o vencedor
        Criatura vencedor = null;
        if (primeiro.getVida() <= 0) {
            vencedor = segundo;
            System.out.println(vencedor.getNome() + " venceu a batalha!");
        } else {
            vencedor = primeiro;
            System.out.println(vencedor.getNome() + " venceu a batalha!");
        }
        sc.close();
        return vencedor;
    }

    public static Criatura determinarPrimeiroAtacante(Criatura c1, Criatura c2) {
        if (c1.getVelocidade() >= c2.getVelocidade()) {
            return c1;
        }else {
            return c2;
        }
    }

    // metodo para executar o turno
    public static void turno(Criatura atacante, Criatura defensor, Scanner sc) {

        boolean turnoValido = false;
        int dano = 0;

        while (!turnoValido) {
            System.out.println(atacante.getNome() + ", escolha seu ataque:");
            System.out.println("1 - Ataque Normal");
            System.out.println("2 - Ataque de Status");
            System.out.println("3 - Ataque Especial");
            System.out.println("4 - Utilizar Item");

            int escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    dano = calcularDano(atacante, defensor, atacante.ataquePadrao());
                    System.out.println(atacante.getNome() + " usou Ataque Normal e causou " + dano + " de dano!");
                    turnoValido = true;
                    break;
                case 2:
                    EfeitoStatus status = atacante.ataqueStatus();
                    System.out.println(atacante.getNome() + " usou Ataque de Status! Status aplicado: " + status);
                    dano = calcularDano(atacante, defensor, atacante.getAtaque() / 2); // ataque de status causa menos dano
                    defensor.setEfeitoInimigo(status);
                    turnoValido = true;
                    break;
                case 3:
                    dano = calcularDano(atacante, defensor, atacante.ataqueEspecial());
                    System.out.println(atacante.getNome() + " usou Ataque Especial e causou " + dano + " de dano!");
                    turnoValido = true;
                    break;
                case 4:
                    System.out.println("Escolha o item para usar:");
                    List<Item> inventario = atacante.getInventario();
                    String listar = atacante.listarInventario();
                    System.out.println(listar);

                    int itemEscolhido = sc.nextInt() - 1;
                    if(itemEscolhido >= 0 && itemEscolhido < inventario.size()) {
                        Item item = inventario.get(itemEscolhido);
                        if(!item.isUsado()) {
                            item.usar(atacante);
                            turnoValido = true;
                        }else {
                            System.out.println("Esse item ja foi usado escolha outro item.");
                        }
                    }else {
                        System.out.println("voce ja utilizou todos so seus itens.");
                    }
                    break;
                default:
                    System.out.println("Escolha inválida! Ataque Normal será usado.");
                    dano = calcularDano(atacante, defensor, atacante.ataquePadrao());
                    turnoValido = true;
                    break;
            }
        }
        defensor.receberDano(dano);
    }

    // metodo para calcular o dano levando em consideracao o tipo
    public static int calcularDano(Criatura atacante, Criatura defensor, int danoBase) {
        String fraquezaDefensor = defensor.getTipo().getFraqueza();
        String tipoAtacante = atacante.getTipo().getNome();

        // Se o tipo do atacante for a fraqueza do defensor, o dano e multiplicado por 1.5
        if (fraquezaDefensor.equalsIgnoreCase(tipoAtacante)) {
            danoBase = (int) (danoBase * 1.5);
            System.out.println("Vantagem de tipo! Dano aumentado.");
        }

        // Considera defesa do defensor (min de dano 1)
        danoBase -= defensor.getDefesa();
        if (danoBase < 0) danoBase = 1;

        return danoBase;
    }
}
