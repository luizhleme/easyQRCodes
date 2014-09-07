package br.com.luizhleme.easyQRCodes.model.qrcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import br.com.luizhleme.easyQRCodes.enums.FileExtension;
import br.com.luizhleme.easyQRCodes.exception.ImagemDomainException;
import br.com.luizhleme.easyQRCodes.exception.QrCodeConverterException;
import br.com.luizhleme.easyQRCodes.exception.QrCodeConverterException.ErrorCode;
import br.com.luizhleme.easyQRCodes.model.imagem.IImagem;
import br.com.luizhleme.easyQRCodes.model.imagem.Imagem;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.HybridBinarizer;

/**
 * This class is a basic implementation of {@link IQrCodeConverter}
 * 
 * @author Luiz Henrique Leme
 *
 */
final class BasicQrConverterImplementation implements IQrCodeConverter, Serializable {

	private static final long serialVersionUID = 6401689309333881042L;

	private static String qrCodeText = "";
	
	BasicQrConverterImplementation(IQrCode qrCode, FileExtension extension,
			String path, String fileName) throws QrCodeConverterException {
		initEncodeQrCode(qrCode, extension, path, fileName);
	}
	
	BasicQrConverterImplementation(String imagem) throws QrCodeConverterException, FileNotFoundException {
		initDecodeQrCode(imagem);
	}

	private void initEncodeQrCode(IQrCode qrCode, FileExtension extension,
			String path, String fileName) throws QrCodeConverterException {

		if (qrCode == null || qrCode.equals(IQrCode.EMPTY_QRCODE)) {
			throw new QrCodeConverterException(
					ErrorCode.INVALID_QRCODE_EXCEPTION);
		}

		if (extension == null || extension.equals(FileExtension.NOT_DEFINED)) {
			throw new QrCodeConverterException(
					ErrorCode.INVALID_EXTENSION_EXCEPTION);
		}

		if (path == null || path.isEmpty()) {
			throw new QrCodeConverterException(ErrorCode.INVALID_PATH_EXCEPTION);
		}

		if (fileName == null || fileName.isEmpty()) {
			throw new QrCodeConverterException(ErrorCode.INVALID_FILE_EXCEPTION);
		}
		encode(qrCode, extension, path, fileName);

	}

	private void initDecodeQrCode(String imagem) throws QrCodeConverterException, FileNotFoundException {
		if (imagem == null || imagem.isEmpty()) {
			throw new QrCodeConverterException(
					ErrorCode.INVALID_QRCODE_EXCEPTION);
		}
		try {
			BasicQrConverterImplementation.qrCodeText = decode(imagem);
		} catch (NotFoundException e) {
			throw new QrCodeConverterException(ErrorCode.INVALID_QRCODE_EXCEPTION);
		}
	}

	private void encode(IQrCode qrCode, FileExtension extension, String path,
			String fileName) throws QrCodeConverterException {
		File file = null;
		
		new File(path).mkdirs();
		
		if (extension.equals(FileExtension.JPG)) {
			fileName = fileName + extension.getExtension();
		} else if (extension.equals(FileExtension.PNG)) {
			fileName = fileName + extension.getExtension();
		}

		try {
			path = path + fileName;
			file = new File(path);
			MatrixToImageWriter.writeToFile(qrCode.getQrCode(),
					extension.toString(), file);
		} catch (IOException e) {
			throw new QrCodeConverterException(
					ErrorCode.INVALID_QRCODE_EXCEPTION);
		}
	}

	private String decode(String imagem) throws QrCodeConverterException,FileNotFoundException, NotFoundException {
		IImagem img = IImagem.EMPTY_IMAGEM;
		BinaryBitmap binaryBitmap = null;
		Result result = null;
		try {
			img = Imagem.valueOf(imagem);
			binaryBitmap = new BinaryBitmap(
					new HybridBinarizer(
							new BufferedImageLuminanceSource(
									img.getImagem())));
			result = new MultiFormatReader().decode(binaryBitmap);
		} catch (ImagemDomainException e) {
			throw new QrCodeConverterException(
					ErrorCode.INVALID_QRCODE_EXCEPTION);
		}
		return result.toString();
	}

	public String getQrCodeText() {
		return qrCodeText;
	}
}
