package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	
	@BeforeAll
	public void  inicializar() {
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("Humberto", LocalDate.now(),new BigDecimal("1000"));
		
	}
	
	@AfterEach //fazer alguma coisa apos o metodo ser chamado
	public static void finalizar() {
		System.out.println("finalizado");
	}
	
	@BeforeAll //antes de todos
	public static void antesDeTodos() {
		System.out.println("antes de todos");
	}
	
	@AfterEach
	public static void depoisDeTodos() {
		System.out.println("depois de todos");
	}
	

	@Test
	public void ReajusteDeveriaSerDe3PorCentoQuandoDesempesenhoForADesejar() {
		service.concederReajuste(funcionario,Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());}
		
		@Test
	public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	    }

	    @Test
	public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
	    service.concederReajuste(funcionario, Desempenho.OTIMO);
	    assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
		
	}

}
