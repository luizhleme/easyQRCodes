package br.com.luizhleme.easyQRCodes.model.qrcode;

import java.io.FileNotFoundException;

import com.google.zxing.NotFoundException;

import br.com.luizhleme.easyQRCodes.exception.QrCodeConverterException;
import br.com.luizhleme.easyQRCodes.model.qrcode.IQrCodeConverter.FileExtension;

/**
 * This class is a builder of {@link IQrCodeConverter} implementations.
 *
 * @author Luiz Henrique Leme
 */
public final class QrCodeConverter {

	private QrCodeConverter() {
	}
	
	public static void writeQrCode(IQrCode qrCode, FileExtension extension,
			String path, String fileName) throws QrCodeConverterException {

		new BasicQrConverterImplementation(qrCode, extension, path, fileName);
	
	}
	
	public static String readQrCode(String imagem) throws QrCodeConverterException, FileNotFoundException, NotFoundException {
		return new BasicQrConverterImplementation(imagem).getQrCodeText();
	}
}
