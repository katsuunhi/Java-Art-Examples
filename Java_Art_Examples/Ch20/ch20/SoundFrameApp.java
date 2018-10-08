package ch20;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

class SoundFrame extends JFrame {
		SoundFrame() {
			JPanel soundPanel = new SoundPanel();		//创建音乐控制板
			add(soundPanel);							//注册
			setTitle("Sound Play Frame");
			setSize(250,80);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			centerWindow(this);
		}
		private void centerWindow(JFrame frame) {		//按屏幕中心位置显示框架的自定义方法
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//计算中心宽度
			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//计算中心高度
			setLocation(centeredWidth, centeredHeight);				//设置显示位置
		}
	}
	public class SoundFrameApp{
    	public static void main(String[] args) {
	       JFrame frame = new SoundFrame();
	       frame.setVisible(true);
	    }
	}
	class SoundPanel extends JPanel implements ActionListener {		//音乐控制板
		JButton playButton, stopButton;							//申明音乐控制按钮
		String musicName;										//申明音乐文件名
		AudioClip music;
		URL localUrl;											//申明文件地址
		SoundPanel() {
			playButton = new JButton("播放音乐");				//创建播放按钮
			add(playButton);
			playButton.addActionListener(this);
			stopButton = new JButton("停止");					//创建停止按钮
			add(stopButton);
			stopButton.addActionListener(this);
			musicName = "sounds\\event.au";					//定义音乐文件名/
			try {												//定义文件路径
				localUrl = new URL("file:" + new File(".").getCanonicalPath() + "//" + musicName);
				music = Applet.newAudioClip(localUrl);			//返回AudioClip对象
			}
			catch (IOException e) {
				System.out.println(e);
			}
		}
		public void actionPerformed(ActionEvent e) {				//事件处理
			Object source = e.getSource();
			if (source == playButton)
				music.loop();									//循环播放
			else if(source == stopButton)
				music.stop();									//停止播放
		}
	}
