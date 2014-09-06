package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link EasyQrCodeException}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class ConverterException extends EasyQrCodeException {
	
	private static final long serialVersionUID = -4183320490940605816L;
	private FormatErrorCode errorCode;
	
	public ConverterException(FormatErrorCode errorCode, Throwable cause) {
		super(errorCode.getDefaultMessage(), cause);
		this.errorCode = errorCode;
	}
	
	public ConverterException(FormatErrorCode errorCode) {
		super(errorCode.getDefaultMessage());
		this.errorCode = errorCode;
	}

	public FormatErrorCode getErrorCode() {
		return errorCode;
	}
}
