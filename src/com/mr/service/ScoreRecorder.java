package com.mr.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ScoreRecorder {
	private static String ScoreFile = "E:\\Program Files\\Eclipse\\2. TM（示例源码+习题答案）\\TM\\sl\\22\\Dinosaur\\data\\soure";
	private static int scores[] = new int[3];
	
	public static void init() {
		File f = new File(ScoreFile);
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}else {
			FileInputStream fis = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			
			try {
				fis = new FileInputStream(f);
				isr = new InputStreamReader(fis);
				br = new BufferedReader(isr);
				
				String re = br.readLine();
				if(!(re == null || "".equals(re))) {
					String vs[] = re.split(",");
					if(vs.length < 3) {
						Arrays.fill(scores, 0);
					}else {
						for(int i = 0;i< 3;i++) {
							scores[i] = Integer.parseInt(vs[i]);
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				try {
					br.close();
					isr.close();
					fis.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			
			
		}
	}
	
	public static void saveScore() {
		String scoreString = scores[0] + "," + scores[1] + "," + scores[2];
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		try {
			fos = new FileOutputStream(ScoreFile);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			bw.write(scoreString);
			bw.flush();
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			try {
				bw.close();
				osw.close();
				fos.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public void addNewScore(int score) {
		int[] scores02 = Arrays.copyOf(scores, 4);
		scores02[3] = score;
		Arrays.sort(scores02);
		scores = Arrays.copyOfRange(scores02, 1, 4);
	}
	
	public static int[] getScores() {
		return scores;
	}



}
