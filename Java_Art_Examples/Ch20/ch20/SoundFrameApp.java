package ch20;

import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

class SoundFrame extends JFrame {
		SoundFrame() {
			JPanel soundPanel = new SoundPanel();		//�������ֿ��ư�
			add(soundPanel);							//ע��
			setTitle("Sound Play Frame");
			setSize(250,80);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			centerWindow(this);
		}
		private void centerWindow(JFrame frame) {		//����Ļ����λ����ʾ��ܵ��Զ��巽��
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension d = tk.getScreenSize();
			int centeredWidth = ((int)d.getWidth() - frame.getWidth())/2;	//�������Ŀ��
			int centeredHeight = ((int)d.getHeight() - frame.getHeight())/2;	//�������ĸ߶�
			setLocation(centeredWidth, centeredHeight);				//������ʾλ��
		}
	}
	public class SoundFrameApp{
    	public static void main(String[] args) {
	       JFrame frame = new SoundFrame();
	       frame.setVisible(true);
	    }
	}
	class SoundPanel extends JPanel implements ActionListener {		//���ֿ��ư�
		JButton playButton, stopButton;							//�������ֿ��ư�ť
		String musicName;										//���������ļ���
		AudioClip music;
		URL localUrl;											//�����ļ���ַ
		SoundPanel() {
			playButton = new JButton("��������");				//�������Ű�ť
			add(playButton);
			playButton.addActionListener(this);
			stopButton = new JButton("ֹͣ");					//����ֹͣ��ť
			add(stopButton);
			stopButton.addActionListener(this);
			musicName = "sounds\\event.au";					//���������ļ���/
			try {												//�����ļ�·��
				localUrl = new URL("file:" + new File(".").getCanonicalPath() + "//" + musicName);
				music = Applet.newAudioClip(localUrl);			//����AudioClip����
			}
			catch (IOException e) {
				System.out.println(e);
			}
		}
		public void actionPerformed(ActionEvent e) {				//�¼�����
			Object source = e.getSource();
			if (source == playButton)
				music.loop();									//ѭ������
			else if(source == stopButton)
				music.stop();									//ֹͣ����
		}
	}
