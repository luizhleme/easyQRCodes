package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link EasyQrCodeException}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class DomainException extends EasyQrCodeException {
	
	private static final long serialVersionUID = 7209233714025996192L;

	private FormatErrorCode errorCode;
	
	public DomainException(FormatErrorCode errorCode, Throwable cause) {
		super(errorCode.getDefaultMessage(), cause);
		this.errorCode = errorCode;
	}
	
	public DomainException(FormatErrorCode errorCode) {
		super(errorCode.getDefaultMessage());
		this.errorCode = errorCode;
	}
	
	public FormatErrorCode getErrorCode() {
		return errorCode;
	}
}
