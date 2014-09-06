package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link DomainException}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class ImagemDomainException extends DomainException {

	private static final long serialVersionUID = 6349224981595750717L;
	private static final String ERROR_MESSAGE = "Invalid image";
	private static final String OUT_OF_BOUNDS_VALUE = "Out of bounds value";

	public enum ErrorCode implements FormatErrorCode {
		NULL_VALUE_EXCEPTION(ERROR_MESSAGE),
		OUT_OF_BOUNDS_VALUE_EXCEPTION(OUT_OF_BOUNDS_VALUE),
		NOT_VALID_IMAGEM(ERROR_MESSAGE);

		private String defaultMessage = "";

		ErrorCode(String defaultMessage) {
			this.defaultMessage = defaultMessage;
		}

		public String getDefaultMessage() {
			return defaultMessage;
		}
	}

	public ImagemDomainException(FormatErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}

	public ImagemDomainException(FormatErrorCode errorCode) {
		super(errorCode);
	}

}
