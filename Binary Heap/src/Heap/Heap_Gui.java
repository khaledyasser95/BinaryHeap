/*
 * Created by JFormDesigner on Wed Mar 22 18:04:43 EET 2017
 */

package Heap;

import com.sun.xml.internal.ws.api.model.MEP;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.GroupLayout;


/**
 * @author khaled samy
 */
public class Heap_Gui extends JFrame {
    public Heap_Gui() {
        initComponents();
    }

    Heappy heap = new Heappy();

    int i = 0;
    ArrayList<String> OP = new ArrayList<>();
    Representation rep = new Representation();

    private void textArea1KeyTyped(KeyEvent e) {
        // TODO add your code here

    }

    private void button1ActionPerformed(ActionEvent e) {
        scan();
        print();
    }

    private void textArea1KeyPressed(KeyEvent e) {
        // TODO add your code here

    }

    private void textArea1KeyReleased(KeyEvent e) {
        // TODO add your code here
        try {
            String type = textArea1.getText();
            if (type.contains(" ")) {
                type = type.trim();
                OP.add(type);
                heap.insert(Integer.parseInt(type));
                textArea1.setText("");
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    private void button3ActionPerformed(ActionEvent e) {

        heap.remove();
        scan();
        // heap.bubbleUp();
    }

    private void scan() {
        StringBuilder value = new StringBuilder();
        i = 0;
        while (i != heap.rep.getSize()) {
            int output = heap.getTree().get(i);
            value.append(output + "  ");
            if (value.toString() != null)
                textField1.setText("  " + value.toString() + "  ");
            else textField1.setText("Empty");


            i++;
        }
    }

    private void print() {
        i = 0;
        StringBuilder value = new StringBuilder();
        while (i != OP.size()) {
            value.append(OP.get(i) + "  ");
            textField2.setText("  " + value.toString() + "  ");
            i++;
        }

    }

    private void sortActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (Quicksort.isSelected()) {

        } else if (MergeSort.isSelected()) {
            heap.merge();
            sorttex.setText("  " + heap.sorttext + "  ");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - khaled samy
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        button1 = new JButton();
        sort = new JButton();
        button3 = new JButton();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        Quicksort = new JRadioButton();
        MergeSort = new JRadioButton();
        sorttex = new JTextField();

        //======== this ========
        setTitle("BINARY HEAP");
        setIconImage(null);
        setType(Window.Type.POPUP);
        setBackground(new Color(0, 102, 102));
        Container contentPane = getContentPane();

        //======== scrollPane1 ========
        {

            //---- textArea1 ----
            textArea1.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    textArea1KeyPressed(e);
                }
                @Override
                public void keyReleased(KeyEvent e) {
                    textArea1KeyReleased(e);
                }
                @Override
                public void keyTyped(KeyEvent e) {
                    textArea1KeyTyped(e);
                }
            });
            scrollPane1.setViewportView(textArea1);
        }

        //---- button1 ----
        button1.setText("Preview");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- sort ----
        sort.setText("Heap Sort");
        sort.addActionListener(e -> sortActionPerformed(e));

        //---- button3 ----
        button3.setText("Delete Minimum");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- label1 ----
        label1.setText("INPUT");
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //---- label2 ----
        label2.setText("OUTPUT");
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        //---- Quicksort ----
        Quicksort.setText("Quick Sort");

        //---- MergeSort ----
        MergeSort.setText("Merge Sort");

        //---- sorttex ----
        sorttex.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                        .addComponent(sort, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(label1, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 294, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(label2, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(button3, GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(Quicksort, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(MergeSort, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sorttex, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button1)
                                .addGap(7, 7, 7)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sort)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(Quicksort)
                                        .addComponent(MergeSort)
                                        .addComponent(sorttex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label2))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - khaled samy
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JButton sort;
    private JButton button3;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JRadioButton Quicksort;
    private JRadioButton MergeSort;
    private JTextField sorttex;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
