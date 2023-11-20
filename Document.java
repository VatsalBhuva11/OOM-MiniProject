import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

@SuppressWarnings("serial")
public class Document {

    public String name;
    public int DocumentID;
    public String category;
    public String tag;
    public String topic;
    public static int counter;
    public static String[] doc_name = new String[100];

    public Document(String S, int id, String topic, String category, String tag) {
        this.name = S;
        this.DocumentID = id;
        this.category = category;
        this.tag = tag;
        this.topic = topic;
    }

    public void getName() {
        System.out.println(name);
    }

    public void getID() {
        System.out.println(DocumentID);
    }

    public String rename(String s) {
        this.name = s;
        return s;
    }

}