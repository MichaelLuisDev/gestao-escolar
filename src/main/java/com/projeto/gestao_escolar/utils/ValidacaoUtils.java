package com.projeto.gestao_escolar.utils;

import com.projeto.gestao_escolar.exception.RegraDeNegocioException;

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
}
