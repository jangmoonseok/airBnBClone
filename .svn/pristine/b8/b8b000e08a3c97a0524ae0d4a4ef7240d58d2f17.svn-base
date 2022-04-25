package kr.or.ddit.bnb.member.controller;

public class getCapchaImgTest {

	public static void main(String[] args) {
		getKey keyService = getKey.getInstance();
		String key = keyService.getKeyStr();
		CaptchaImg imgService = CaptchaImg.getInstance();
		String img = imgService.imgFileName(key);
		
		System.out.println(key);
		System.out.println(img);
	}

}
