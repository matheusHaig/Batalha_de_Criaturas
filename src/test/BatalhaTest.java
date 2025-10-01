package test;

import Batalha.Main;
import Criatura.Criatura;
import TiposElementais.Agua;
import TiposElementais.Fogo;
import TiposElementais.TipoElemental;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class BatalhaTest {

    @Test
    public void velocidadeTest() {

        Criatura c1 = new Criatura("Draco", 100, 300, 10, 15, new Fogo("Fogo"));
        Criatura c2 = new Criatura("aqua", 100, 20, 10, 18, new Agua("Agua"));

        Criatura primeiroAtacar = Main.determinarPrimeiroAtacante(c1, c2);

        assertEquals(c2, primeiroAtacar);
    }

    @Test
    public void vidaTest() {

        Criatura c1 = new Criatura("Draco", 100, 50, 10, 20, new Fogo("Fogo"));
        Criatura c2 = new Criatura("Aqua", 10, 5, 5, 5, new Agua("Agua"));

        Scanner sc = new Scanner(new java.io.ByteArrayInputStream("1\n".getBytes()));

        Criatura vencedor = Main.executarBatalha(c1, c2, sc);

        assertEquals("Draco", vencedor.getNome());
        assertEquals(0, c2.getVida());
        assertTrue(c1.getVida() > 0);

    }

    @Test
    public void danoTest() {

        Criatura c1 = new Criatura("Draco", 100, 1, 10, 20, new Fogo("Fogo"));
        Criatura c2 = new Criatura("Aqua", 10, 5, 20, 5, new Agua("Agua"));

        int dano = Main.calcularDano(c1, c2, c1.ataquePadrao());

        assertEquals(1, dano);

    }
}
