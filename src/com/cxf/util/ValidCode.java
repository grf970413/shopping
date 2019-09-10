package com.cxf.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.*;

/**
  *  生成验证码工具类
 * @author 啊哈
 *
 */
public class ValidCode {
	public static String getCode(ServletOutputStream os) {
		int width = 150,height = 100;
		BufferedImage bi = new BufferedImage( width,height,BufferedImage.TYPE_INT_RGB );
		Graphics gra = bi.getGraphics();
		gra.setColor( Color.WHITE );
		gra.fillRect( 0,0,width,height );
		Random random = new Random();
		List<Integer> randomList = new ArrayList<>();
		for(int i = 0;i < 4;i++){
			randomList.add( random.nextInt( 10 ) );
		}
		Color[] colors = {Color.CYAN,Color.GRAY,Color.RED,Color.GREEN,Color.PINK};
		gra.setFont( new Font( "宋体",Font.ITALIC | Font.BOLD,40 ) );

		for(int i = 0 ; i < randomList.size();i++){
			gra.setColor( colors[random.nextInt( colors.length )]);
			gra.drawString( String.valueOf( randomList.get( i ) ),i * 40 , 70+(random.nextInt( 21 ) - 10));
		}
		try {
			ImageIO.write( bi,"jpg",os );
		} catch (IOException e) {
			e.printStackTrace();
		}
		String code = "";
		for(int i = 0 ;i <randomList.size();i++){
			code += String.valueOf( randomList.get( i ) );
		}
		return code;
	}
}
