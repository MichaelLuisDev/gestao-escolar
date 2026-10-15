package com.projeto.gestao_escolar.utils;

import com.projeto.gestao_escolar.exception.RegraDeNegocioException;
import com.projeto.gestao_escolar.model.Enum.TurnoTurma;

public class ValidacaoUtils {

    private ValidacaoUtils() { }

    public static void validarId(Long id, String campo) {
        if (id == null || id <= 0) {
            throw new RegraDeNegocioException("0 ID do "+ campo + " deve ser maior que zero");
        }
    }

    public static void validarTextoObrigatorio(String valor, String campo, int limite) {
        if (valor == null || valor.isBlank()) {
            throw new RegraDeNegocioException(campo + " obrigatorio");
        }
        if (valor.length() > limite) {
            throw new RegraDeNegocioException(campo + " deve ter no maximo " + limite + " caracteres");
        }
    }
    public static void validarInteiroObrigatorio(String valor, String campo, int limite) {
        if (valor == null || valor.isBlank()) {
            throw new RegraDeNegocioException(campo + " obrigatorio");
        }

        try {
            Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            throw new RegraDeNegocioException(campo + " deve ser um número válido");
        }
    }
    public static void validarSemestre(String valor, String campo, int limite) {
        if (valor == null || valor.isBlank()) {
            throw new RegraDeNegocioException(campo + " obrigatorio");
        }

        // Regex explica: ^[0-9]{4} (4 dígitos) + \. (ponto literal) + [1-3]$ (dígito de 1 a 3)
        String regex = "^\\d{4}\\.[1-3]$";

        if (!valor.trim().matches(regex)) {
            throw new RegraDeNegocioException(campo + " deve estar no formato válido, ex: 2026.1, 2026.2 ou 2026.3");
        }
    }

    public static void validarTurnoObrigatorio(TurnoTurma valor, String campo, int limite) {
        if (valor == null) {
            throw new RegraDeNegocioException(campo + " obrigatorio");
        }
    }

}
