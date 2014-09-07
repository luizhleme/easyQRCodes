package br.com.luizhleme.easyQRCodes;

import java.io.FileNotFoundException;

import com.google.zxing.NotFoundException;

import br.com.luizhleme.easyQRCodes.enums.FileExtension;
import br.com.luizhleme.easyQRCodes.exception.QrCodeConverterException;
import br.com.luizhleme.easyQRCodes.exception.QrCodeDomainException;
import br.com.luizhleme.easyQRCodes.model.qrcode.IQrCode;
import br.com.luizhleme.easyQRCodes.model.qrcode.QrCode;
import br.com.luizhleme.easyQRCodes.model.qrcode.QrCodeConverter;

public class Exemplo {

public static void main(String[] args) {
		
		generateQRCode("#EasyQRCodes a Simple QRCode example");
		readingQRCode("C:\\easyQRCode\\sample.jpg");
	}

	private static void readingQRCode(String file) {
		System.out.println("Reading a QRCode using EasyQRCodes...");
		try {
			String qrCode = QrCodeConverter.readQrCode(file);
			System.out.println("The QRCode value is: " + qrCode);
		} catch (QrCodeConverterException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void generateQRCode(String text) {
		System.out.println("Generating a QRCode using EasyQRCode...");
		IQrCode qrCode;
		try {
			qrCode = QrCode.valueOf(text);
			QrCodeConverter.writeQrCode(qrCode, FileExtension.JPG, "C:\\easyQRCode\\", "sample");
		} catch (QrCodeDomainException e) {
			e.printStackTrace();
		} catch (QrCodeConverterException e) {
			e.printStackTrace();
		}
	}
	
}
