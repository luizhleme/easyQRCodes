package br.com.luizhleme.easyQRCodes.model.imagem;

import java.io.FileNotFoundException;

import br.com.luizhleme.easyQRCodes.exception.ImagemDomainException;

/**
 * This class is a builder of {@link IImagem} implementations.
 *
 * @author Luiz Henrique Leme
 */
public final class Imagem {

	private Imagem() {
	}
	
	public static IImagem valueOf(String imagem) throws ImagemDomainException, FileNotFoundException {
		return new BasicImagemImplementation(imagem);
	}
}
