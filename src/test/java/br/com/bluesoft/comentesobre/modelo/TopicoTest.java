package br.com.bluesoft.comentesobre.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TopicoTest {

	private String assunto;
	private Topico topico;
	
	@Before
	public void inicializacao() {
		this.assunto = "Metodologias";
		this.topico = new Topico(this.assunto);
	}
	
	@Test
	public void deveriaExistirUmTopicoComUmDeterminadoAssuntoValido() {
		assertEquals("Deveria haver um t�pico com assunto: ", this.assunto, this.topico.getAssunto());
	}
	
	@Test
	public void deveriaAdicionarUmComentarioValidoAUmTopicoExistente() {
		// Dado
		String email = "jucabala@jucabala.com.br";
		String texto = "H� v�rios tipos de metodologias.";
		
		// Quando
		this.topico.adiciona(new Comentario(this.topico, email, texto));

		// Ent�o
		assertEquals("deve haver um t�pico com coment�rio: ", 1, this.topico.getTotalDeComentarios());
	}
	
	@Test
	public void deveriaAdicionarTresComentariosValidosAUmTopicoExistente() {
		// Dado
		String email = "jucabala@jucabala.com.br";
		String texto = "H� v�rios tipos de metodologias.";
		
		Comentario comentario = new Comentario(this.topico, email, texto);
		
		// Quando
		this.topico.adiciona(comentario);
		this.topico.adiciona(comentario);
		this.topico.adiciona(comentario);
		
		// Ent�o
		assertEquals("deve haver um t�pico com coment�rios: ", 3, this.topico.getTotalDeComentarios());
	}

	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoComAssuntoIgualANull() {
		
		try {
			new Topico(null);
			fail("Deveria ter lan�ado uma IllegalArgumentException para assunto null.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um assunto v�lido para o t�pico.", falha.getMessage());
		}
	}
	
	@Test
	public void deveriaLancarUmaIllegalArgumentExceptionParaTopicoComAssuntoEmBranco() {
		
		try {
			new Topico("");
			fail("Deveria ter lan�ado uma IllegalArgumentException para assunto em branco.");
		} catch (IllegalArgumentException falha) {
			assertEquals("Informe um assunto v�lido para o t�pico.", falha.getMessage());
		}
	}
	
}
