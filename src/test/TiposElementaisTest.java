package test;

import Batalha.Main;
import Criatura.Criatura;
import TiposElementais.TipoElemental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TiposElementaisTest {

    @Test
    public void testDanoSemFraqueza() {

        TipoElemental tipoAtacante = mock(TipoElemental.class);
        when(tipoAtacante.getNome()).thenReturn("Fogo");

        TipoElemental tipoDefensor = mock(TipoElemental.class);
        when(tipoDefensor.getFraqueza()).thenReturn("Agua");

        Criatura atacante = new Criatura("Draco", 100, 20, 10, 15, tipoAtacante);
        Criatura defensor = new Criatura("Aqua", 100, 18, 12, 12, tipoDefensor);

        int dano = Main.calcularDano(atacante, defensor, atacante.ataquePadrao());

        assertEquals(8, dano);
    }

    @Test
    public void testDanoComFraqueza() {

        TipoElemental tipoAtacante = mock(TipoElemental.class);
        when(tipoAtacante.getNome()).thenReturn("Fogo");

        TipoElemental tipoDefensor = mock(TipoElemental.class);
        when(tipoDefensor.getFraqueza()).thenReturn("Fogo");

        Criatura atacante = new Criatura("Draco", 100, 20, 10, 15, tipoAtacante);
        Criatura defensor = new Criatura("Aqua", 100, 18, 12, 12, tipoDefensor);

        int dano = Main.calcularDano(atacante, defensor, atacante.ataquePadrao());

        assertEquals(18, dano);
    }
}
