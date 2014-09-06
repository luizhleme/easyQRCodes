package br.com.luizhleme.easyQRCodes.model.imagem;

import java.awt.image.BufferedImage;

import br.com.luizhleme.easyQRCodes.exception.ImagemDomainException;

/**
 * {@link IImagem} 
 * 
 * @author Luiz Henrique Leme
 *
 */
public interface IImagem {
	
	final IImagem EMPTY_IMAGEM = new EmptyImagem();
	
	int getHeight();
	
	int getPixel();
	
	int getWidth();
	
	BufferedImage getImagem() throws ImagemDomainException;
}
