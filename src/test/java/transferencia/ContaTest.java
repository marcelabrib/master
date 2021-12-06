package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente joao;
    Cliente maria;
    Conta contaJoao;
    Conta contaMaria;

    @BeforeEach
    void setUp() {
        joao = new Cliente("João", "12345678900", "111111111");
        maria = new Cliente("Maria", "09876543211", "222222222");

        contaJoao = new Conta("0012", "00112233", 2500.00, joao);
        contaMaria = new Conta("0098", "00998877", 3500.00, maria);

    }

    @Test
    public void realizarTransacao(){
        contaMaria.realizarTransferencia(1000.00, contaJoao);
        assertEquals(1500.00, contaMaria.getSaldo());
        assertEquals(4500.00, contaJoao.getSaldo());
    }

    @Test
    public void validarTransacaoInvalida(){
        boolean resultado = contaMaria.realizarTransferencia(3500.00, contaJoao);
        assertFalse(resultado);
    }

    @Test
    public void validaProprietario(){
        assertEquals(maria, contaMaria.getProprietario());
    }
}