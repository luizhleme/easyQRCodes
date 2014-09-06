package br.com.luizhleme.easyQRCodes.model.imagem;

import java.awt.image.BufferedImage;
import java.io.Serializable;
/**
 * This class is an empty implementation of {@link IImagem}
 * 
 * @author Luiz Henrique Leme
 *
 */
final class EmptyImagem implements IImagem, Serializable {
	
	private static final long serialVersionUID = 8040577023118980914L;

	EmptyImagem() {
	}
	
	public int getPixel(int x, int y) {
		return 0;
	}

	public BufferedImage getImagem() {
		return new BufferedImage(0, 0, BufferedImage.TYPE_INT_RGB);
	}

	public int getHeight() {
		return 0;
	}

	public int getPixel() {
		return 0;
	}

	public int getWidth() {
		return 0;
	}
}
