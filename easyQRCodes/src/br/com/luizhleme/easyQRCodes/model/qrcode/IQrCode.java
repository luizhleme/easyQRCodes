package br.com.luizhleme.easyQRCodes.model.qrcode;

import com.google.zxing.common.BitMatrix;

/**
 * {@link IQrCode}
 * 
 * @author Luiz Henrique Leme
 *
 */
public interface IQrCode {
	
	final IQrCode EMPTY_QRCODE = new EmptyQrCode();
	
	BitMatrix getQrCode();
}
