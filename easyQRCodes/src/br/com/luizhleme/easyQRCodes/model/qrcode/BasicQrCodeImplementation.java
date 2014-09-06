package br.com.luizhleme.easyQRCodes.model.qrcode;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import br.com.luizhleme.easyQRCodes.exception.QrCodeDomainException;
import br.com.luizhleme.easyQRCodes.exception.QrCodeDomainException.ErrorCode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
/**
 * This class is a basic implementation of {@link IQrCode}
 * 
 * @author Luiz Henrique Leme
 *
 */
final class BasicQrCodeImplementation implements IQrCode, Serializable {

	private static final long serialVersionUID = -5143816463676935464L;

	private static final int LENGTH = 1;
	private static final String CHARSET = "ISO-8859-1";
	private static final int HEIGTH = 100;
	private static final int WIDTH = 100;
	private String text = "";
	private BitMatrix qrCode = null;
	private int height = 0;
	private int width = 0;

	BasicQrCodeImplementation(String text) throws QrCodeDomainException {
		init(text);
	}

	private void init(String text) throws QrCodeDomainException {
		if (text == null || text.isEmpty()) {
			throw new QrCodeDomainException(ErrorCode.NOT_VALID_VALUE);
		} else if (text.length() == LENGTH) {
			throw new QrCodeDomainException(
					ErrorCode.OUT_OF_BOUNDS_VALUE_EXCEPTION);
		} else {
			this.text = text;
		}
		this.height = HEIGTH;
		this.width = WIDTH;
		encode();
	}

	public BitMatrix getQrCode() {
		return this.qrCode;
	}
	
	private void encode() throws QrCodeDomainException {
		Charset charSet = Charset.forName(CHARSET);
		CharsetEncoder encoder = charSet.newEncoder();
		byte[] bite = null;
		String data = null;
		
		try {
			CharBuffer charBuffer = CharBuffer.wrap(this.text);
			ByteBuffer encode = encoder.encode(charBuffer);
			bite = encode.array();
		} catch (CharacterCodingException e) {
			throw new QrCodeDomainException(ErrorCode.TEXT_ECONDING_EXCEPTION);
		}
		
		try {
			data = new String(bite, CHARSET);
		} catch (UnsupportedEncodingException e) {
			throw new QrCodeDomainException(ErrorCode.TEXT_ECONDING_EXCEPTION);
		}
		
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			this.qrCode = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE,
					this.width, this.height);
		} catch (WriterException e) {
			throw new QrCodeDomainException(ErrorCode.NOT_VALID_VALUE);
		}
	}
	
	@Override
	public String toString() {
		return "[IQrCode " + qrCode + "]";
	}
}
