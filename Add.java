import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

@SuppressWarnings("serial")

public class Add extends JPanel {

    JTextField t;
    JTextField t1;
    JTextField t2;
    JTextField t3;
    JTextField t4;
    JTextField t5;
    JTextField t6;
    JTextField t7;
    JTextField t8;
    JTextField t9;
    public static int[] checks = { 0, 0, 0 }; // name, topic, category

    public void addDocumentToList() {
        if (checks[0] == 1 && checks[1] == 1 && checks[2] == 1) {
            String name = t.getText();
            String topic = t2.getText();
            String category = t4.getText();
            String tag = t6.getText();

            Document.doc_name[Document.counter] = name;
            Topic.topic[Document.counter] = topic;
            Category.category[Document.counter] = category;
            Tag.tags[Document.counter] = tag;

            Document.counter = Document.counter + 1;
        }
    }

    public Add() {

        setLayout(new GridLayout(5, 3));

        // get input of doc name
        t = new JTextField("ENTER DOCUMENT NAME");
        t.setSize(300, 300);
        t.setEditable(true);

        // display doc name
        t1 = new JTextField("DOCUMENT NAME: NONE");
        t1.setSize(300, 300);
        t1.setEditable(true);

        JButton j1 = new JButton("PROCEED");

        t2 = new JTextField("ENTER TOPIC");
        t2.setSize(300, 300);
        t2.setEditable(true);

        t3 = new JTextField("TOPIC: NONE");
        t3.setSize(300, 300);
        t3.setEditable(true);

        JButton j2 = new JButton("PROCEED");

        t4 = new JTextField("ENTER CATEGORY");
        t4.setSize(300, 300);
        t4.setEditable(true);

        t5 = new JTextField("CATEGORY: NONE");
        t5.setSize(300, 300);
        t5.setEditable(true);

        JButton j3 = new JButton("PROCEED");

        t6 = new JTextField("ENTER TAGS (IF ANY ELSE TYPE NIL)");
        t6.setSize(300, 300);
        t6.setEditable(true);

        t7 = new JTextField("TAGS: NONE");
        t7.setSize(300, 300);
        t7.setEditable(true);

        JButton j4 = new JButton("PROCEED");

        t8 = new JTextField("CLICK TO GO TO MAIN PAGE");
        t8.setSize(300, 300);
        t8.setEditable(true);

        t9 = new JTextField("CLICK TO GO TO MAIN PAGE");
        t9.setSize(300, 300);
        t9.setEditable(true);

        JButton j5 = new JButton("MAIN PAGE");

        j1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = t.getText();
                // displau doc name on rhs
                t1.setText("DOCUMENT NAME: " + s1);
                checks[0] = 1;
            }
        });

        j2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = t2.getText();
                t3.setText("TOPIC: " + s1);
                checks[1] = 1;
            }
        });

        j3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s1 = t4.getText();
                t5.setText("CATEGORY: " + s1);
                checks[2] = 1;
            }

        });

        j4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Current documents are: ");
                int i;
                for (i = 0; i < Document.counter - 1; i++) {
                    System.out.print(Document.doc_name[i] + ", ");
                }
                System.out.print(Document.doc_name[i] + "\n");
                String s1 = t6.getText();
                t7.setText("TAGS: " + s1);
                addDocumentToList();

                JFrame jFrame = new JFrame();
                jFrame.setTitle("CHOOSING PAGE");

                Add a = new Add();
                Container cPane = jFrame.getContentPane();
                Newclass template = new Newclass(a, cPane);
                jFrame.setSize(template.getSize());
                jFrame.setResizable(false);
                cPane.add(template);

                jFrame.setVisible(true);
                jFrame.setLocationRelativeTo(null);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });

        j5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame jFrame = new JFrame();
                jFrame.setTitle("CHOOSING PAGE");

                Add a = new Add();
                Container cPane = jFrame.getContentPane();
                Newclass template = new Newclass(a, cPane);
                jFrame.setSize(template.getSize());
                jFrame.setResizable(false);
                cPane.add(template);

                jFrame.setVisible(true);
                jFrame.setLocationRelativeTo(null);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        this.add(t);
        this.add(j1);
        this.add(t1);
        this.add(t2);
        this.add(j2);
        this.add(t3);
        this.add(t4);
        this.add(j3);
        this.add(t5);
        this.add(t6);
        this.add(j4);
        this.add(t7);
        this.add(t8);
        this.add(j5);
        this.add(t9);

    }

}
