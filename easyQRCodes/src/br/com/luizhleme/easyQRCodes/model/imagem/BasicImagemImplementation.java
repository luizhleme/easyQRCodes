package br.com.luizhleme.easyQRCodes.model.imagem;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

import javax.imageio.ImageIO;

import br.com.luizhleme.easyQRCodes.exception.ImagemDomainException;
import br.com.luizhleme.easyQRCodes.exception.ImagemDomainException.ErrorCode;
/**
 * This class is a basic implementation of {@link IImagem}
 * 
 * @author Luiz Henrique Leme
 *
 */
final class BasicImagemImplementation implements IImagem, Serializable {

	private static final long serialVersionUID = 7905626319718827693L;

	private static final int LENGTH = 1;

	private String imagem = "";
	private BufferedImage bufferedImage = null;
	private FileInputStream image;

	BasicImagemImplementation(String imagem) throws ImagemDomainException, FileNotFoundException {
		init(imagem);
	}

	private void init(String imagem) throws ImagemDomainException, FileNotFoundException {
		if (imagem == null || imagem.isEmpty()) {
			throw new ImagemDomainException(ErrorCode.NULL_VALUE_EXCEPTION);
		} else if (imagem.length() == LENGTH) {
			throw new ImagemDomainException(
					ErrorCode.OUT_OF_BOUNDS_VALUE_EXCEPTION);
		} else {
			this.imagem = imagem;
			image = new FileInputStream(imagem);
		}
		imageToByte();
	}

	public int getPixel(int x, int y) {

		if (this.bufferedImage != null) {
			return this.bufferedImage.getRGB(x, y);
		}
		return 0;
	}

	public int getHeight() {
		if (this.bufferedImage != null) {
			return this.bufferedImage.getHeight();
		}
		return 0;
	}

	public int getPixel() {
		return 0;
	}

	public int getWidth() {
		if (this.bufferedImage != null) {
			return this.bufferedImage.getWidth();
		}
		return 0;
	}
	
	public BufferedImage getImagem() throws ImagemDomainException {
		return this.bufferedImage;
	}

	private void imageToByte() throws ImagemDomainException {
		try {
			this.bufferedImage = ImageIO.read(image); 
		} catch (Exception e) {
			throw new ImagemDomainException(ErrorCode.NOT_VALID_IMAGEM);
		}
	}

	public String toString() {
		return "[IImagem " + imagem + "]";
	}
}
