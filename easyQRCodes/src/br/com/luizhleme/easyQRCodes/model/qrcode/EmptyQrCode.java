package br.com.luizhleme.easyQRCodes.model.qrcode;

import java.io.Serializable;

import com.google.zxing.common.BitMatrix;
/**
 * This class is an empty implementation of {@link IQrCode}
 * 
 * @author Luiz Henrique Leme
 *
 */
final class EmptyQrCode implements IQrCode, Serializable {

	private static final long serialVersionUID = 2105245687023393265L;
	
	EmptyQrCode() {
	}

	public BitMatrix getQrCode() {
		return null;
	}
}
