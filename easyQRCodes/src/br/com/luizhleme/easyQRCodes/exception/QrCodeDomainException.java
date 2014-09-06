package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link DomainException}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class QrCodeDomainException extends DomainException {

	private static final long serialVersionUID = 1538859061914379621L;

	public static final String ERROR_MESSAGE = "Invalid QRCode.";
	public static final String ERROR_STRING_MESSAGE = "Invalid input string.";
	private static final String OUT_OF_BOUNDS_VALUE = "Out of bounds value.";
	public static final String ERROR_ENCODING = "An error occured when encoding the text.";

	public enum ErrorCode implements FormatErrorCode {
		NULL_VALUE_EXCEPTION(ERROR_MESSAGE),
		NOT_VALID_VALUE(ERROR_STRING_MESSAGE),
		OUT_OF_BOUNDS_VALUE_EXCEPTION(OUT_OF_BOUNDS_VALUE), 
		TEXT_ECONDING_EXCEPTION(ERROR_ENCODING);
		
		private String defaultMessage = "";
		
		ErrorCode(String defaultMesage) {
			this.defaultMessage = defaultMesage;
		}

		public String getDefaultMessage() {
			return defaultMessage;
		}
	}
	
	public QrCodeDomainException(FormatErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
	
	public QrCodeDomainException(FormatErrorCode errorCode) {
		super(errorCode);
	}
}
