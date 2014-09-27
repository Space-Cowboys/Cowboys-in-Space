package music;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicPlayer{

	private final MediaPlayer title;
	//private MediaPlayer flying = new MediaPlayer("flying.wav");
	
	public MusicPlayer(){
            this.title = new MediaPlayer(new Media("file://title.wav"));
	}
	
	public void playTitle(){
            title.play();
	}
	
	//public void playFlying(){
	//	flying.play();
	//}
	
	public static void main(String[] args){
            MusicPlayer music;
            music = new MusicPlayer();
            music.playTitle();
        }
}