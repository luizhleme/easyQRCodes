package br.com.luizhleme.easyQRCodes.enums;
/**
 * Possibles File Extensions
 * 
 * @author Luiz Henrique Leme
 */
public enum FileExtension {
	NOT_DEFINED(""),
	JPG(".jpg"),
	PNG(".png");
	
	private String extension = "";
	
	FileExtension(String extension) {
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}
}
