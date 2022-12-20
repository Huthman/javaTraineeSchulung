package org.example.ownClassesAndInterfaces;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.TimerTask;

public class FreeDiskSpaceTimerTask extends TimerTask {
    private long errorThresholdInB = 1000*1024;
    private long freeDiskSpace;
    private boolean displayedInSystemTray;
    private TrayIcon icon;
    private SystemTray systemTray;

    public FreeDiskSpaceTimerTask(){
        try {
            String url =
                    "https://cdn4.iconfinder.com/data/icons/common-toolbar/36/Save-16.png";
            ImageIcon imageIcon = new ImageIcon( new URL( url ) );
            icon = new TrayIcon( imageIcon.getImage() );
            systemTray = SystemTray.getSystemTray();
            systemTray.add( icon );
        }
        catch ( Exception e ) { e.printStackTrace(); }
    }
    @Override
    public void run() {
        freeDiskSpace = java.io.File.listRoots()[0].getFreeSpace();
        if (freeDiskSpace < errorThresholdInB) {
            System.err.printf("Free disk space below %dMB%n", errorThresholdInB);
            if (!displayedInSystemTray) {
                displayedInSystemTray = false;
            }
            icon.displayMessage( "Achtung", "Platte voll", TrayIcon.MessageType.INFO);
        } else {
            if (displayedInSystemTray) {
                switchDisplay();
            }
        }
        System.out.printf("Free disk space: %.2fGB%n", (freeDiskSpace / (Math.pow(1024, 3))));
    }

    public void switchDisplay() {
    }

}
