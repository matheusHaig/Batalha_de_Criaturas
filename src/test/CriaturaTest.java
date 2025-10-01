package test;

import Batalha.Main;
import Criatura.Criatura;
import EfeitoStatus.EfeitoStatus;
import TiposElementais.Agua;
import TiposElementais.Fogo;
import TiposElementais.TipoElemental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CriaturaTest {

    @Test
    public void ataquePadraoTest() {

        TipoElemental tipo = mock(TipoElemental.class);

        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);

       int dano = c1.ataquePadrao();

       assertEquals(20, dano);
    }

    @Test
    public void ataqueEspecialTest() {

        TipoElemental tipo = mock(TipoElemental.class);

        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, tipo);

        int dano = c1.ataqueEspecial();

        assertEquals(30, dano);
    }

    @Test
    public void ataqueStatuslTest() {

        TipoElemental tipo = mock(TipoElemental.class);
        when(tipo.getStatus()).thenReturn(EfeitoStatus.QUEIMAR);

        Criatura c1 = new Criatura("Draco", 100, 20, 10, 15, new Fogo("Fogo"));

        EfeitoStatus efeitoStatus = c1.ataqueStatus();

        assertEquals(EfeitoStatus.QUEIMAR, efeitoStatus);
    }

    @Test
    public void receberDanoTest() {

        Criatura atacante = new Criatura("Draco", 100, 300, 10, 15, new Fogo("Fogo"));
        Criatura defensor = new Criatura("aqua", 100, 20, 10, 15, new Agua("Agua"));

        int dano = Main.calcularDano(atacante, defensor, atacante.ataqueEspecial());
        defensor.receberDano(dano);
        assertEquals(0, defensor.getVida());
    }
}
