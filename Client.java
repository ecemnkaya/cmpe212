import java.net.*;
import java.io.*;
public class Client
{

    private Socket socket            = null;
    private DataInputStream  input   = null;
    private DataOutputStream out     = null;
	private DataInputStream in       =  null;

	private boolean run = true;
    public Client(String address, int port)
    {

        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
 
            input  = new DataInputStream(System.in);

            out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
 
        String line = "";

        while (run)
        {
            try
            {
				System.out.println("1. Login with user and password");
				System.out.println("2. date");
				System.out.println("3. time");
				System.out.println("4. capTurkey");
				System.out.println("5. quit");

                line = input.readLine();
                
				if(line.equals("1")){
					System.out.println("Username:");
					String user = input.readLine();
					System.out.println("Password:");
					String pass = input.readLine();
					line = "user:" + user + ",pass:" + pass;
				}
				else if(line.equals("2")) 
					line = "date";
				else if(line.equals("3")) 
					line = "time";
				else if(line.equals("4")) 
					line = "capTurkey";
				else if(line.equals("5")) 
					line = "quit";

				out.writeUTF(line);
				String sv = in.readUTF();
				if(sv.equals("Bye bye"))
					run = false;
				System.out.println("Server: " + sv);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
 
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 555);
    }
}