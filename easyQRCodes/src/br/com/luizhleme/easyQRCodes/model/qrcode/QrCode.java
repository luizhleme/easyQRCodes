package br.com.luizhleme.easyQRCodes.model.qrcode;

import br.com.luizhleme.easyQRCodes.exception.QrCodeDomainException;

/**
 * This class is a builder of {@link IQrCode} implementations.
 *
 * @author Luiz Henrique Leme
 */
public final class QrCode {

	private QrCode() {
	}
	
	public static IQrCode valueOf(String text) throws QrCodeDomainException {
		return new BasicQrCodeImplementation(text);
	}
	
	public static IQrCode emptyValue() throws QrCodeDomainException {
		return new EmptyQrCode();
	}
}
