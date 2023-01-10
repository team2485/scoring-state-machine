import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class StateMachineDemo {
	
	enum mStates
	{
		StateFault,
		StateInit,
		StateSetup,
		StateIdle,
		StateRun,
		StateJail,
	}

	private static mStates mState;
	public static char mKey;
	
	private static int mDelay;
	
	public void set_mKey(char key) {
		mKey = key;
	}
	
	class stateMachineTask extends TimerTask
	{
		public void run()
		{
			//System.out.println("state\n");
			switch(mState)
			{
				case StateFault :
					break;
				case StateInit :
					mDelay = 1;
					mKey = 0;
					mState = mStates.StateSetup;
					break;
				case StateSetup :
					if(mDelay != 0) {
						mDelay--;
						if(mDelay == 0) {
							System.out.println("Press 'a' to goto run\n");
							mDelay = 10;
							mState = mStates.StateIdle;
						}
					}
					break;
				case StateIdle :
					if(mKey != 0) {
						if(mKey == 'a') {
							System.out.println("Going to StateRun press 'b' to go back to idle");
							mDelay = 10;
							mState = mStates.StateRun;
							mKey = 0;
						}
						else {
							System.out.println("Wrong key, go to StateJail for 5 seconds");
							mDelay = 50;
							mState = mStates.StateJail;;
							mKey = 0;
						}

					}
					else if(mDelay != 0) {
						mDelay--;
						if(mDelay == 0) {
							System.out.println("Idle\n");
							mDelay = 10;
						}
					}
					break;
				case StateRun :
					if(mKey == 'b') {
						System.out.println("Going to StateIdle press 'a' to go back to run");
						mDelay = 10;
						mState = mStates.StateIdle;
						mKey = 0;
					}
					else if(mDelay != 0) {
						mDelay--;
						if(mDelay == 0) {
							System.out.println("Run\n");
							mDelay = 10;
						}
					}
					break;
				case StateJail :
					if(mDelay != 0) {
						if(mDelay % 10 == 0) {
							System.out.println("Waiting in StateJail no way out but waiting\n");
						}
						mDelay--;
						if(mDelay == 0) {
							System.out.println("Out of StateJail going back to StateIdle\n");
							mDelay = 10;
							mState = mStates.StateIdle;
							mKey = 0;
						}
						
					}
					break;
			}
			
		}
	}
	
	public StateMachineDemo() {
		
		//set the initial state to StateInit
        mState = mStates.StateInit;
        
        //instantiate a new timer
		Timer stateTimer = new Timer();
		
		//instantiate a new task
	    TimerTask task = new stateMachineTask();
	    
	    //schedule the task 
	    stateTimer.schedule(task , 0, 100);
	}
	
    public static void main(String args[]) {
    	
    	//set up a non-blocking way of getting keyboard input.
        JFrame frame = new JFrame("Key Listener");
        Container contentPane = frame.getContentPane();
        KeyListener listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                mKey = event.getKeyChar();
            }
            @Override
            public void keyReleased(KeyEvent event) {
               
            }
            @Override
            public void keyTyped(KeyEvent event) {
                
            }
        };
        JTextField textField = new JTextField();
        textField.addKeyListener(listener);
        contentPane.add(textField, BorderLayout.NORTH);
        frame.pack();
        frame.setVisible(true);

        //instantiate a new state machine demo 
        new StateMachineDemo();

    }
	
}

