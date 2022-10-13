package com.mr.model;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Obstacle {
	public BufferedImage image;
	private BufferedImage stone,cacti;
	public int x,y;
	private int SPEED = 4;
	
	
	public Obstacle() {
		try {
			cacti = ImageIO.read(new File("E:\\Program Files\\Eclipse\\2. TM��ʾ��Դ��+ϰ��𰸣�\\TM\\sl\\22\\Dinosaur\\image\\������.png"));
			stone = ImageIO.read(new File("E:\\Program Files\\Eclipse\\2. TM��ʾ��Դ��+ϰ��𰸣�\\TM\\sl\\22\\Dinosaur\\image\\ʯͷ.png"));
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		Random r = new Random();
		if(r.nextInt(2) == 0) {
			image = stone;
		}else {
			image = cacti;
		}
		
		x = 800;
		y = 200-image.getHeight();
	}
	
	public void move() {
		x -= SPEED;
	}
	
	public boolean isLive() {
		if(x <= -image.getWidth()) {
			return false;
		}else {
			return true;
		}
	}
	
    public Rectangle getBounds() {
        if (image == cacti) {// ���ʹ��������ͼƬ
            // ���������Ƶı߽�
            return new Rectangle(x + 7, y, 15, image.getHeight());
        }
        // ����ʯͷ�ı߽�
        return new Rectangle(x + 5, y + 4, 23, 21);
    }

}
