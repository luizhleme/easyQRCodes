package br.com.luizhleme.easyQRCodes.exception;

/**
 * This class is an implementation of {@link ConverterException}
 * 
 * @author Luiz Henrique Leme
 *
 */
public class QrCodeConverterException extends ConverterException {
	
	private static final long serialVersionUID = 4415428189922433097L;
	
	public static final String INVALID_QRCODE = "Invalid QRCode.";
	public static final String INVALID_EXTENSION = "Invalid file extension.";
	public static final String INVALID_PATH = "Invalid path or it not exists.";
	public static final String INVALID_FILE = "Invalid file or it not exists";

	public enum ErrorCode implements FormatErrorCode {
		INVALID_QRCODE_EXCEPTION (INVALID_QRCODE),
		INVALID_EXTENSION_EXCEPTION (INVALID_EXTENSION),
		INVALID_PATH_EXCEPTION (INVALID_PATH),
		INVALID_FILE_EXCEPTION (INVALID_FILE);
		
		private String defaultMessage = "";
		
		ErrorCode(String defaultMessage) {
			this.defaultMessage = defaultMessage;
		}

		public String getDefaultMessage() {
			return defaultMessage;
		}
	}

	public QrCodeConverterException(FormatErrorCode errorCode, Throwable cause) {
		super(errorCode, cause);
	}
	
	public QrCodeConverterException(FormatErrorCode errorCode) {
		super(errorCode);
	}
}
