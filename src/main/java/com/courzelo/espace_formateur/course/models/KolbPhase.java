package com.courzelo.espace_formateur.course.models;

import java.io.InputStream;
import org.bson.types.Binary;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class KolbPhase {
	private Binary imageFile;
	private InputStream pdfFile;
	private InputStream txtFile; 
	private InputStream videoFile;
	public KolbPhase(Binary image,InputStream video,InputStream pdf,InputStream txt) {
		this.imageFile=image;
		this.videoFile=video;
		this.pdfFile=pdf;
		this.txtFile=txt;
	}
	
}
