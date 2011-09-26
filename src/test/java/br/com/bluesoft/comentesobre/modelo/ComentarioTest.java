package br.com.bluesoft.comentesobre.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ComentarioTest {

	private Topico topico;
	private String email;
	private String texto;
	
	@Before
	public void inicializacao() {
		this.topico = new Topico("Metodologias");
		this.email = "jucabala@jucabala.com.br";
		this.texto = "Meu coment�rio se resume a um coment�rio.";
	}
	
	@Test
	public void deveriaExistirUmComentarioValidoParaUmTopicoExistente() {
		// Dado
		
		// Quando
		Comentario comentario = new Comentario(this.topico, this.email, this.texto);
		
		// Ent�o
		assertEquals("deve haver um t�pico: ", this.topico.getAssunto(), comentario.getTopico().getAssunto());
		assertEquals("deve haver um e-mail: ", this.email, comentario.getEmail());
		assertEquals("deve haver um coment�rio: ", this.texto, comentario.getTexto());
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoIgualANull() {
		
		try {
			new Comentario(null, this.email, this.texto);
			fail("Deveria ter lan�ado uma IllegalArgumentException para t�pico null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um t�pico v�lido para o coment�rio.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumenteExceptionParaEMailIgualANull() {
		
		try {
			new Comentario(this.topico, null, "Este coment�rio n�o � v�lido.");
			fail("Deveria ter lan�ado uma IllegalArgumentException para e-mail null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um e-mail v�lido para o coment�rio.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaEMailEmBranco() {
		
		try {
			new Comentario(this.topico, "", "N�o quero fazer nenhum coment�rio.");
			fail("Deveria ter lan�ado uma IllegalArgumentException para e-mail em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um e-mail v�lido para o coment�rio.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTextoIgualANull() {
		
		try {
			new Comentario(this.topico, "juca@bala.com.br", null);
			fail("Deveria ter lan�ado uma IllegalArgumentException para texto null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um coment�rio v�lido.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTextoEmBranco() {
		
		try {
			new Comentario(this.topico, "juca@bala.com.br", "");
			fail("Deveria ter lan�ado uma IllegalArgumenteException para texto em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um coment�rio v�lido.", falha.getMessage());
		}
	}
}
