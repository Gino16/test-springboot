package com.test.junit.data;

import com.test.junit.entities.Banco;
import com.test.junit.entities.Cuenta;

import java.math.BigDecimal;
import java.util.Optional;

public class Datos {
//    public static final Cuenta CUENTA_001 = new Cuenta(1L, "Gino", new BigDecimal("1200"));
//    public static final Cuenta CUENTA_002 = new Cuenta(2L, "David", new BigDecimal("1500"));
//    public static final Banco BANCO = new Banco(1L, "BBVA", 0);

    public static Optional<Cuenta> crearCuenta001 () {
        return Optional.of(new Cuenta(1L, "Gino", new BigDecimal("1200")));
    }

    public static Optional<Cuenta> crearCuenta002 () {
        return Optional.of(new Cuenta(2L, "David", new BigDecimal("1500")));
    }

    public static Optional<Banco> crearBanco(){
        return Optional.of(new Banco(1L, "BBVA", 0));
    }
}
