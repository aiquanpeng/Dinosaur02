package com.mr.model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dinosaur {
	public static BufferedImage image;
	private static BufferedImage image01;
	private static BufferedImage image02;
	private static BufferedImage image03;
	private int x;
	private static int y;
	private static int Y_LOWEST = 120;
	private static int jumpHeight = 100;
	private static int jumpValue = 0;
	private static boolean jumpStatus = false;
	private static int stepTimer = 0;
	private static int FREASH = 20;
	
	public Dinosaur() {
		x = 50;
		y = Y_LOWEST;
		
		try {
			image01 = ImageIO.read(new File("E:/Program Files/Eclipse/2. TM（示例源码+习题答案）/TM/sl/22/Dinosaur/image/恐龙1.png"));
			image02 = ImageIO.read(new File("E:/Program Files/Eclipse/2. TM（示例源码+习题答案）/TM/sl/22/Dinosaur/image/恐龙2.png"));
			image03 = ImageIO.read(new File("E:/Program Files/Eclipse/2. TM（示例源码+习题答案）/TM/sl/22/Dinosaur/image/恐龙3.png"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
	
	public static void move() {
		step();
		if(jumpStatus) {
			if(y >= Y_LOWEST) {
				jumpValue = -4;
			}
			if(y <= Y_LOWEST - jumpHeight) {
				jumpValue = 4;
			}
			y += jumpValue;
			
			if(y >= Y_LOWEST) {
				jumpStatus = false;
			}
		}
	}
	
	private static void step() {
		int tmp = stepTimer /250 % 3;
		switch(tmp) {
		case 1:
			image = image01;
			break;
		case 2:
			image = image02;
			break;
		default:
			image = image03;
			break;
		}
		stepTimer += FREASH;
	}
	
	
	
	public Rectangle getFootBounds() {
		return new Rectangle(x + 30, y + 59, 29, 18);
	}
	
    public Rectangle getHeadBounds() {
        return new Rectangle(x + 66, y + 25, 32, 22);
    }
	
	
	
	
	
	
	
	
	
	

}
