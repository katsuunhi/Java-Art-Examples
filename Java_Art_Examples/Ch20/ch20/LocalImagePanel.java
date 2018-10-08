package ch20;

import javax.swing.*;
import java.awt.*;
import java.net.*;
import java.io.*;

class LocalImagePanel extends JPanel {
	Toolkit tk;									//����Toolkit
	Image flowers, myPhoto;
	URL flowersUrl, myPhotoUrl;

	public LocalImagePanel() throws  Exception {						//������
		flowersUrl = new URL("file:" + new File(".").getCanonicalPath() + "\\ch20\\flowers.gif");
		System.out.println("file:" + new File(".").getCanonicalPath() + "\\ch20\\flowers.gif");
		myPhotoUrl = new URL("file:" + new File(".").getCanonicalPath() + "\\images\\ygao.jpg");
		tk = Toolkit.getDefaultToolkit();
		flowers = tk.getImage(flowersUrl);
		myPhoto = tk.getImage(myPhotoUrl);
	}
	public void paintComponent(Graphics g){
  		super.paintComponent(g);
  		Graphics2D gg = (Graphics2D) g;
    	gg.drawImage(flowers, 0, 0, this);		//�ڵ�ǰ���ư�����ʾͼ��
		gg.drawImage(myPhoto, 265, 4, this);
	}
}