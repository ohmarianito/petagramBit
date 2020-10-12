package com.coursera.petagrambit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.smtp.*;


public class Contacto extends AppCompatActivity {


    String  to = "malonso@outlook.com",
            subject = "test",
            from = "mis.web.registros@gmail",
            cc = null, bcc = null, url = null;

    String mailhost = "mis.web.registros@gmail";
    String mailer = "smtpsend";

    String file = null;
    String protocol = null, host = "smtp.gmail.com", user = "mis.web.registros@gmail", password = "";
    String record = null;	// name of folder in which to record mail

    boolean debug = false;
    boolean verbose = false;
    boolean auth = false;

    String prot = "smtp";
    BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Button button = (Button) findViewById(R.id.btnEnviarMail);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail(v);
            }
        });
    }

    public void sendMail(View v){
        try {

            Properties props = System.getProperties();
            if (mailhost != null)
                props.put("mail." + prot + ".host", mailhost);
            if (auth)
                props.put("mail." + prot + ".auth", "true");

            Session session = Session.getInstance(props, null);
            if (debug)
                session.setDebug(true);
            Message msg = new MimeMessage(session);
            if (from != null)
                msg.setFrom(new InternetAddress(from));
            else
                msg.setFrom();

            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to, false));
            if (cc != null)
                msg.setRecipients(Message.RecipientType.CC,
                        InternetAddress.parse(cc, false));
            if (bcc != null)
                msg.setRecipients(Message.RecipientType.BCC,
                        InternetAddress.parse(bcc, false));

            msg.setSubject(subject);

            String text = recollet(in);

            if (file != null) {
                // Attach the specified file.
                // We need a multipart message to hold the attachment.
                MimeBodyPart mbp1 = new MimeBodyPart();
                mbp1.setText(text);
                MimeBodyPart mbp2 = new MimeBodyPart();
                mbp2.attachFile(file);
                MimeMultipart mp = new MimeMultipart();
                mp.addBodyPart(mbp1);
                mp.addBodyPart(mbp2);
                msg.setContent(mp);
            } else {
                // If the desired charset is known, you can use
                //setText(text, charset)
                //msg.setText(text);
            }

            msg.setHeader("X-Mailer", mailer);
            msg.setSentDate(new Date());

            // send the thing off
	    /*
	     * The simple way to send a message is this:
	     *
	    Transport.send(msg);
	     *
	     * But we're going to use some SMTP-specific features for
	     * demonstration purposes so we need to manage the Transport
	     * object explicitly.
	     */
            SMTPTransport t = (SMTPTransport)session.getTransport(prot);
            try {
                if (auth)
                    t.connect(mailhost, user, password);
                else
                    t.connect();
                t.sendMessage(msg, msg.getAllRecipients());
            } finally {
                if (verbose)
                    System.out.println("Response: " +
                            t.getLastServerResponse());
                t.close();
            }
            System.out.println("\nMail was sent successfully.");

            if (record != null) {
                // Get a Store object
                Store store = null;
                if (url != null) {
                    URLName urln = new URLName(url);
                    store = session.getStore(urln);
                    store.connect();
                } else {
                    if (protocol != null)
                        store = session.getStore(protocol);
                    else
                        store = session.getStore();

                    // Connect
                    if (host != null || user != null || password != null)
                        store.connect(host, user, password);
                    else
                        store.connect();
                }

                Folder folder = store.getFolder(record);
                if (folder == null) {
                    System.err.println("Can't get record folder.");
                    System.exit(1);
                }
                if (!folder.exists())
                    folder.create(Folder.HOLDS_MESSAGES);

                Message[] msgs = new Message[1];
                msgs[0] = msg;
                folder.appendMessages(msgs);

                System.out.println("Mail was recorded successfully.");
            }

        } catch (Exception e) {
            /*
             * Handle SMTP-specific exceptions.
             */
            if (e instanceof SendFailedException) {

                MessagingException sfe = (MessagingException)e;
                if (sfe instanceof SMTPSendFailedException) {
                    SMTPSendFailedException ssfe =
                            (SMTPSendFailedException)sfe;
                    System.out.println("SMTP SEND FAILED:");
                    if (verbose)
                        System.out.println(ssfe.toString());
                    System.out.println("  Command: " + ssfe.getCommand());
                    System.out.println("  RetCode: " + ssfe.getReturnCode());
                    System.out.println("  Response: " + ssfe.getMessage());

                } else {

                    if (verbose)
                        System.out.println("Send failed: " + sfe.toString());
                }

                Exception ne;

                while ((ne = sfe.getNextException()) != null &&
                        ne instanceof MessagingException) {

                    sfe = (MessagingException)ne;

                    if (sfe instanceof SMTPAddressFailedException) {
                        SMTPAddressFailedException ssfe =
                                (SMTPAddressFailedException)sfe;
                        System.out.println("ADDRESS FAILED:");
                        if (verbose)
                            System.out.println(ssfe.toString());
                        System.out.println("  Address: " + ssfe.getAddress());
                        System.out.println("  Command: " + ssfe.getCommand());
                        System.out.println("  RetCode: " + ssfe.getReturnCode());
                        System.out.println("  Response: " + ssfe.getMessage());
                    } else if (sfe instanceof SMTPAddressSucceededException) {
                        System.out.println("ADDRESS SUCCEEDED:");
                        SMTPAddressSucceededException ssfe =
                                (SMTPAddressSucceededException)sfe;
                        if (verbose)
                            System.out.println(ssfe.toString());
                        System.out.println("  Address: " + ssfe.getAddress());
                        System.out.println("  Command: " + ssfe.getCommand());
                        System.out.println("  RetCode: " + ssfe.getReturnCode());
                        System.out.println("  Response: " + ssfe.getMessage());
                    }
                }
            } else {
                System.out.println("Got Exception: " + e);
                if (verbose)
                    e.printStackTrace();
            }
        }
        Toast.makeText(getBaseContext(), "Gracias por contactarnos!", Toast.LENGTH_SHORT).show();
    }
    public static String recollet(BufferedReader in) throws IOException {
        String lines;

        StringBuffer sb = new StringBuffer();

        while ((lines = in.readLine()) != null) {
            sb.append(lines);
            sb.append("\n");
        }
        return sb.toString();
    }



}