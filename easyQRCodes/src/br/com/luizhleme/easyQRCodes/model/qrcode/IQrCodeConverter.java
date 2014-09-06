package br.com.luizhleme.easyQRCodes.model.qrcode;

/**
 * {@link IQrCodeConverter}
 * 
 * @author Luiz Henrique Leme
 *
 */
public interface IQrCodeConverter {

	enum FileExtension {
		NOT_DEFIDED,
		JPG,
		PGN;
	}
	
	String getQrCodeText();
}
