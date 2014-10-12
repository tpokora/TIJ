package concurrency.cw;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Frame implements ActionListener {
	private JFrame frame = new JFrame();
	private JLabel label = new JLabel("0");
	private JTextField textfield = new JTextField(5);
	private ExecutorService exec;
	
	public Frame() {
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		JPanel textfieldPanel = new JPanel();
		JButton startButton = new JButton("START");
		JButton stopButton = new JButton("STOP");
		frame.add(textfieldPanel, frame);
		frame.add(label, frame);
		frame.add(startButton, frame);
		frame.add(stopButton, frame);
		textfieldPanel.setLayout(new FlowLayout());
		textfieldPanel.setMaximumSize(new Dimension(200, 30));
		textfieldPanel.add(new JLabel("FROM: "));
		textfieldPanel.add(textfield);
		textfield.setText("10");
		label.setAlignmentX(frame.CENTER_ALIGNMENT);
		startButton.setAlignmentX(frame.CENTER_ALIGNMENT);
		stopButton.setAlignmentX(frame.CENTER_ALIGNMENT);
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private JLabel getLabel() {
		return label;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "START": {
				Double d = Double.parseDouble(textfield.getText());
				Integer i = d.intValue();
				exec = Executors.newCachedThreadPool();
				exec.execute(new CountDown(i));
				break;
			}
			case "STOP": {
				exec.shutdownNow();
				break;
			}
			default: break;
		}
	}
	
	class CountDown implements Runnable {
		private int countDown;
		
		public CountDown(int countDown) {
			this.countDown = countDown;
		}
		
		public void run() {
			try {
				while(countDown != 0) {
					getLabel().setText("Countdown: " + countDown);
					System.out.println("Countdown: " + countDown);
					TimeUnit.SECONDS.sleep(1);
					countDown--;
				} 
			} catch(InterruptedException e) {
				getLabel().setText("PRZERWANO");
				System.out.println("PRZERWANO");
			}
			getLabel().setText("BOOOOOOMM!!");
			System.out.println("BOOOOOOMM!!");
		}
	}
}

public class Cw20Swing {
	
	public static void main(String[] args) {
		new Frame();
	}

}
