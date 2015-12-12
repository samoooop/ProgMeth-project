package util;



import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class AudioUtility {
	 public static final AudioClip bgm = loadAudio("res/sound/bgm.wav");
	 public static final AudioClip clickSound = loadAudio("res/sound/click.wav");
	 public static final AudioClip flipSound = loadAudio("res/sound/flip.wav");
	public static final AudioClip crashSound = loadAudio("res/sound/crash.wav");
	public static final AudioClip solvedSound = loadAudio("res/sound/solved.wav");
	private static boolean isMuted;
	
	private static AudioClip loadAudio(String directory){
		AudioClip a  ;
		try{
			ClassLoader load = DrawingUtility.class.getClassLoader();
			a = Applet.newAudioClip((load.getResource(directory)).toURI().toURL());
		}catch(Exception e){a = null;}
	return a;
	}
	
	public static void setMuted(boolean isMuted) {
		AudioUtility.isMuted = isMuted;
	}
	
	public static boolean isMuted() {
		return isMuted;
	}
	
	public static void playSound(AudioClip au){
		if(!isMuted){
			au.play();
		}
	}
}