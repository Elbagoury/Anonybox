import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import javax.swing.JOptionPane;

public class client {
	public static void main(String[] args) {
	try {
		String ooo = "";
		String out = "";
		String ip = JOptionPane.showInputDialog("Server IP:");
		if (ip.contentEquals("")) {
			JOptionPane.showMessageDialog(null,"No IP entered, exiting...");
			System.exit(1);
		}else {
			//Nothing
		}
		String key = JOptionPane.showInputDialog("Encryption Key:");
		if (key.contentEquals("")) {
			JOptionPane.showMessageDialog(null,"No Key entered, exiting...");
			System.exit(1);
		}else {
			//Nothing
		}
        Socket s = new Socket(ip,1111);
        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        while (true) {
        String cmd = JOptionPane.showInputDialog("Enter the command:");
        jsncp.write(dos,cmd,key);
        dos.flush();
        out = jsncp.read(dis,key);
        if (out.contains("html")||out.contains("<")) {
            File temp = new File("temp.html");
            temp.createNewFile();
            Files.write(Paths.get("temp.html"), out.getBytes());
        }else {
        	JOptionPane.showMessageDialog(null,out);
        }
        }
}catch(Exception e) {
	e.printStackTrace();
}
	}
	}