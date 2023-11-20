import java.io.*;
import java.util.*;
import java.applet.*;
import java.awt.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.TableView.TableRow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

@SuppressWarnings("serial")

public class Newclass extends JPanel {

    private JLabel showDocuments;

    public Newclass(Add a, Container cPane) {

        setSize(800, 800);
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addDocument = new JButton("ADD DOCUMENT");
        addDocument.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        addDocument.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally
        addDocument.setBackground(Color.RED);
        addDocument.setForeground(Color.YELLOW);

        buttonPanel.add(addDocument);

        addDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Add add = new Add();
                add.setSize(getSize());
                next(cPane);
                cPane.add(add);
                cPane.revalidate();
                cPane.repaint();
            }
        });

        JButton deleteDocument = new JButton("DELETE DOCUMENT");
        deleteDocument.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        deleteDocument.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button horizontally;
        deleteDocument.setBackground(Color.RED);
        deleteDocument.setForeground(Color.YELLOW);

        buttonPanel.add(deleteDocument);

        deleteDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Delete delete = new Delete();
                delete.setSize(getSize());
                next(cPane);
                cPane.add(delete);
                cPane.revalidate();
                cPane.repaint();
            }
        });

        JButton editDocument = new JButton("EDIT DOCUMENT");
        editDocument.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        editDocument.setAlignmentX(Component.CENTER_ALIGNMENT);
        editDocument.setBackground(Color.RED);
        editDocument.setForeground(Color.YELLOW);

        buttonPanel.add(editDocument);

        editDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Edit edit = new Edit();
                edit.setSize(getSize());
                next(cPane);
                cPane.add(edit);
                cPane.revalidate();
                cPane.repaint();
            }
        });

        JButton retreiveDocument = new JButton("RETREIVE DOCUMENT");
        retreiveDocument.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        retreiveDocument.setAlignmentX(Component.CENTER_ALIGNMENT);
        retreiveDocument.setBackground(Color.RED);
        retreiveDocument.setForeground(Color.YELLOW);

        buttonPanel.add(retreiveDocument);

        retreiveDocument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Retreive retreive = new Retreive();
                retreive.setSize(getSize());
                next(cPane);
                cPane.add(retreive);
                cPane.revalidate();
                cPane.repaint();
            }
        });

        showDocuments = new JLabel("Current Documents:");
        showDocuments.setPreferredSize(new Dimension(100, 100)); // Set preferred size
        showDocuments.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel extra = new JLabel(" ");
        buttonPanel.add(extra);
        buttonPanel.add(showDocuments);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                if (row == 0) {
                    c.setBackground(Color.YELLOW);
                    return c;
                } else {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : Color.LIGHT_GRAY);
                }
                return c;
            }
        });

        model.addColumn("Id");
        model.addColumn("Doc Name");
        model.addColumn("Category");
        model.addColumn("Tag");
        model.addColumn("Topic");

        model.addRow(new Object[] { "ID", "DOC NAME", "CATEGORY", "TAG", "TOPIC" });

        Document[] docs = Retreive.getAllDocs();
        for (int i = 0; i < Document.counter; i++) {
            if (docs[i] != null) {
                model.addRow(new Object[] { docs[i].DocumentID, docs[i].name, docs[i].category, docs[i].tag,
                        docs[i].topic });
            }
        }

        // Color ivory = new Color(255, 255, 208);
        // table.setBackground(ivory);

        buttonPanel.add(table);
        this.add(buttonPanel, BorderLayout.CENTER);

    }

    class ColumnColorRenderer extends DefaultTableCellRenderer {
        Color backgroundColor, foregroundColor;

        public ColumnColorRenderer(Color backgroundColor, Color foregroundColor) {
            super();
            this.backgroundColor = backgroundColor;
            this.foregroundColor = foregroundColor;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            cell.setBackground(backgroundColor);
            cell.setForeground(foregroundColor);
            return cell;
        }
    }

    public void next(Container cPane) {
        cPane.remove(this);
    }

}
