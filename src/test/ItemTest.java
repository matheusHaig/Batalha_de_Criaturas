package test;

import Criatura.Criatura;
import Itens.*;
import TiposElementais.TipoElemental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemTest {

    @Test
    public void EspadaTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Item item = new Espada("Espada de Ferro");

        c1.adicionarItem(item);

        item.usar(c1);

        assertEquals(25, c1.getAtaque());
    }

    @Test
    public void armaduraTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Item item = new Armadura("Armadura de fogo");

        c1.adicionarItem(item);

        item.usar(c1);

        assertEquals(15, c1.getDefesa());
    }

    @Test
    public void botasTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Item item = new Botas("Botas de velocidade");

        c1.adicionarItem(item);

        item.usar(c1);

        assertEquals(20, c1.getVelocidade());
    }

    @Test
    public void pocaoTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Item item = new Pocao("elixir de lava");

        c1.adicionarItem(item);

        item.usar(c1);

        assertEquals(105, c1.getVida());
    }

    @Test
    public void testItemUsadoUmaVez() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Espada espada = new Espada("Espada de Ferro");

        c1.adicionarItem(espada);

        espada.usar(c1);
        assertTrue(espada.isUsado());

        espada.usar(c1);
        assertTrue(espada.isUsado());
    }

    @Test
    public void listarItensTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getNome()).thenReturn("Fogo");


        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);
        Espada espada = new Espada("Espada de Ferro");
        Armadura armadura = new Armadura("Armadura de Fogo");

        c1.adicionarItem(espada);
        c1.adicionarItem(armadura);

        espada.usar(c1);

        String inventario = c1.listarInventario();

        assertTrue(inventario.contains("Espada de Ferro (usado)"));
        assertTrue(inventario.contains("Armadura de Fogo"));

    }
}
