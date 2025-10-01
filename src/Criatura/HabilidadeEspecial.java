package Criatura;

import EfeitoStatus.EfeitoStatus;

public interface HabilidadeEspecial {
    int ataquePadrao();
    EfeitoStatus ataqueStatus();
    int ataqueEspecial();
}
