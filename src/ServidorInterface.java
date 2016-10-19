    // Fig. 21.3: ServerInterface.java
    // Set up a ServerInterface that will receive a connection
    // from a client, send a string to the client,
    // and close the connection.
     
    package Sockets;
     
    import java.io.*;
    import java.net.*;
    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;
     
    public class ServerInterface extends JFrame {
       private JTextField enter;
       private JTextArea display;
       ObjectOutputStream output;
       ObjectInputStream input;
     
       public ServerInterface(){
          super( "ServerInterface" );
          Container c = getContentPane();
          enter = new JTextField();
          enter.setEnabled( false );
          enter.addActionListener(
             new ActionListener() {
                public void actionPerformed( ActionEvent e ){
                   sendData( e.getActionCommand() );
                }
             }
          );
     
          c.add( enter, BorderLayout.NORTH );
          display = new JTextArea();
          c.add( new JScrollPane( display ),
                 BorderLayout.CENTER );
          setSize( 300, 150 );
          show();
       }
     
       public void runServerInterface(){
          ServerInterfaceSocket ServerInterface;
          Socket connection;
          int counter = 1;
          try {
             // Step 1: Create a ServerInterfaceSocket.
             ServerInterface = new ServerInterfaceSocket( 5050, 100 );
             while ( true ) {
                // Step 2: Wait for a connection.
                display.setText( "Waiting for connection\n" );
                connection = ServerInterface.accept();
                display.append( "Connection " + counter + " received from: " +
                   connection.getInetAddress().getHostName() );
     
                // Step 3: Get input and output streams.
                output = new ObjectOutputStream(connection.getOutputStream() );
                output.flush();
     
                input = new ObjectInputStream(connection.getInputStream() );
                display.append( "\nGot I/O streams\n" );
     
                // Step 4: Process connection.
                String message = "ServerInterface>>> Connection successful";
                output.writeObject( message );
                output.flush();
                enter.setEnabled( true );
     
                do {
                   try {
                      message = (String) input.readObject();
                      display.append( "\n" + message );
                      display.setCaretPosition(display.getText().length() );
                   }catch ( ClassNotFoundException cnfex ) {
                      display.append("\nUnknown object type received" );
                   }
                } while ( !message.equals( "CLIENT>>> TERMINATE" ) );
     
                // Step 5: Close connection.
                display.append( "\nUser terminated connection" );
                enter.setEnabled( false );
                output.close();
                input.close();
                connection.close();
                ++counter;
             }
          }catch ( EOFException eof ) {
             System.out.println( "Client terminated connection" );
          }catch ( IOException io ) {
             io.printStackTrace();
          }
       }
     
       private void sendData( String s ){
          try {
             output.writeObject( "ServerInterface>>> " + s );
             output.flush();
             display.append( "\nServerInterface>>>" + s );
          }catch ( IOException cnfex ) {
             display.append("\nError writing object" );
          }
       }
     
       public static void main( String args[] ){
          ServerInterface app = new ServerInterface();
          app.addWindowListener(
             new WindowAdapter() {
                public void windowClosing( WindowEvent e ){
                   System.exit( 0 );
                }
             }
          );
     
          app.runServerInterface();
       }
    }
     
    /**************************************************************************
     * (C) Copyright 1999 by Deitel & Associates, Inc. and Prentice Hall.     *
     * All Rights Reserved.                                                   *
     *                                                                        *
     * DISCLAIMER: The authors and publisher of this book have used their     *
     * best efforts in preparing the book. These efforts include the          *
     * development, research, and testing of the theories and programs        *
     * to determine their effectiveness. The authors and publisher make       *
     * no warranty of any kind, expressed or implied, with regard to these    *
     * programs or to the documentation contained in these books. The authors *
     * and publisher shall not be liable in any event for incidental or       *
     * consequential damages in connection with, or arising out of, the       *
     * furnishing, performance, or use of these programs.                     *
     *************************************************************************/