package com.test.junit;

import com.test.junit.entities.Cuenta;
import com.test.junit.repositories.CuentaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class IntegracionJpaTest {
    @Autowired
    CuentaRepository cuentaRepository;

    @Test
    void test_find_by_id() {
        Optional<Cuenta> cuenta = cuentaRepository.findById(1L);
        assertTrue(cuenta.isPresent());
        assertEquals("Gino", cuenta.orElseThrow().getPersona());
        assertEquals("1200.00", cuenta.orElseThrow().getSaldo().toPlainString());
    }

    @Test
    void test_find_by_persona() {
        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Gino");
        assertTrue(cuenta.isPresent());
        assertEquals("Gino", cuenta.orElseThrow().getPersona());
        assertEquals("1200.00", cuenta.orElseThrow().getSaldo().toPlainString());
    }


    @Test
    void test_find_by_persona_throw_exception() {
        Optional<Cuenta> cuenta = cuentaRepository.findByPersona("Josh");
        assertThrows(NoSuchElementException.class, cuenta::orElseThrow);
        assertFalse(cuenta.isPresent());
    }

    @Test
    void test_find_all(){
        List<Cuenta> cuentas = cuentaRepository.findAll();
        assertFalse(cuentas.isEmpty());
        assertEquals(2, cuentas.size());
    }

    @Test
    void test_save() {
        // Given
        Cuenta cuenta1 = new Cuenta(null, "Jose", new BigDecimal("2000"));

        // When
        Cuenta cuenta = cuentaRepository.save(cuenta1);
//        Cuenta cuenta = cuentaRepository.findByPersona("Jose").orElseThrow();
//        Cuenta cuenta = cuentaRepository.findById(save.getId()).orElseThrow();

        // Then
        assertEquals("Jose", cuenta.getPersona());
        assertEquals("2000", cuenta.getSaldo().toPlainString());
//        assertEquals(3, cuenta.getId());
    }

    @Test
    void test_update() {
        // Given
        Cuenta cuenta1 = new Cuenta(null, "Jose", new BigDecimal("2000"));

        // When
        Cuenta cuenta = cuentaRepository.save(cuenta1);
//        Cuenta cuenta = cuentaRepository.findByPersona("Jose").orElseThrow();
//        Cuenta cuenta = cuentaRepository.findById(save.getId()).orElseThrow();

        // Then
        assertEquals("Jose", cuenta.getPersona());
        assertEquals("2000", cuenta.getSaldo().toPlainString());
//        assertEquals(3, cuenta.getId());


        // When
        cuenta.setSaldo(new BigDecimal("2500"));
        Cuenta cuentaActualizada = cuentaRepository.save(cuenta);

        // Then
        assertEquals("Jose", cuentaActualizada.getPersona());
        assertEquals("2500", cuentaActualizada.getSaldo().toPlainString());

    }

    @Test
    void test_delete() {
        Cuenta cuenta = cuentaRepository.findById(2L).orElseThrow();

        assertEquals("David", cuenta.getPersona());

        cuentaRepository.delete(cuenta);

        assertThrows(NoSuchElementException.class, () -> cuentaRepository.findByPersona("David").orElseThrow());

        assertEquals(1, cuentaRepository.findAll().size());
    }
}
