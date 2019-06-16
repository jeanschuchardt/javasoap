package speculate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.verify;


class testEspeculate {

	@Mock
	private Speculate a = new Speculate();
	
	@Before
	public void setUp() {
		
		  MockitoAnnotations.initMocks(this);
		  
		a.preRegistro("jean", 1, "antonio", 2);
		a.preRegistro("jessica", 3, "lucas", 4);
		a.preRegistro("pricila", 6, "pas", 5);

		
		a.registraJogador("jean");
		a.registraJogador("antonio");
		a.registraJogador("jessica");
		a.registraJogador("lucas");
		a.registraJogador("pricila");
		
	}
	
	@Test
	void testRegistraComSucesso() {
		
		assertEquals(0, a.registraJogador("lucas")); 
		
	}
	
	@Test
	@Ignore
	void testRegistraFalha() {
		
		assertEquals(0, a.registraJogador("jean")); 
		
	}
	
	@Test
	void testTemPartida() {
		assertEquals(0, a.temPartida(1));
		
		assertEquals(1, a.temPartida(3));
		
	}
	

}
