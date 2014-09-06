package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link Exception}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class EasyQrCodeException extends Exception{

	private static final long serialVersionUID = 6872104185657179760L;

	public EasyQrCodeException() {
		super();
	}
	
	public EasyQrCodeException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public EasyQrCodeException(String message) {
		super(message);
	}
	
	public EasyQrCodeException(Throwable cause) {
		super(cause);
	}
}
