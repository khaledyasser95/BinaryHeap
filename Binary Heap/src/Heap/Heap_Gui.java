/*
 * Created by JFormDesigner on Wed Mar 22 18:04:43 EET 2017
 */

package Heap;

import javax.swing.table.*;



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
        heap.getTree().clear();
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
                scan();
                print();
            }
        } catch (Exception x) {
            System.out.println("INPUT" + x.getMessage());
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        int index = heap.rep.getSize() - 1;

        if (index >= 0) {
            heap.remove();
            scan();

        } else {
            textField1.setText("  Empty");
            Swap.setText("Empty Array");
        }

        index--;


    }

    private void scan() {
        StringBuilder value = new StringBuilder();
        i = 0;
        while (i != heap.rep.getSize()) {
            int output = heap.getTree().get(i);
            value.append(output + "  ");
            Swap.setText(heap.swappy);
            textField1.setText("  " + value.toString() + "  ");
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

    void sortprint() {
        StringBuilder value = new StringBuilder();
        i = 0;
        while (i != heap.rep.getSize()) {
            int output = heap.getTree().get(i);
            value.append(output + "  ");
            sorttex.setText("  " + value.toString() + "  ");
            i++;
        }
    }

    private int mergeindex = 1;
    private int selecindex = 1;
    private int quickindex = 1;
    private int heapsortindex = 1;
    private void sortActionPerformed(ActionEvent e) {
        // TODO add your code here

        if (Quicksort.isSelected()) {
            heap.Quicksort();
            table1.setValueAt(heap.com.getQuicksort() + " ns", quickindex, 0);
            sortprint();
            quickindex++;
        } else if (MergeSort.isSelected()) {

            heap.merge();
            table1.setValueAt(heap.com.getMergeSort() + " ns", mergeindex, 1);
            sorttex.setText("  " + heap.sorttext + "  ");
            mergeindex++;

        } else if (selection.isSelected()) {
            heap.selectionSort();
            table1.setValueAt(heap.com.getSelection() + " ns", selecindex, 2);

            sortprint();
            selecindex++;

        } else if (heapsort.isSelected()) {
            heap.heapSort();
            table1.setValueAt(heap.com.getHeapSort() + " ns", heapsortindex, 3);
            sortprint();
            heapsortindex++;

        }

        Swap.setText(heap.swappy);
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        heap.getTree().clear();
        heap.rep.setSize(0);
        OP.clear();
        textField1.setText("");
        textField2.setText("");
        sorttex.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - khaled samy
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textField1 = new JTextField();
        button1 = new JButton();
        button3 = new JButton();
        textField2 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        Quicksort = new JRadioButton();
        MergeSort = new JRadioButton();
        sorttex = new JTextField();
        Swap = new JLabel();
        selection = new JRadioButton();
        heapsort = new JRadioButton();
        table1 = new JTable();
        sort = new JButton();
        button2 = new JButton();

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

        //---- textField1 ----
        textField1.setEditable(false);
        textField1.setBackground(Color.white);

        //---- button1 ----
        button1.setText("Preview");
        button1.addActionListener(e -> button1ActionPerformed(e));

        //---- button3 ----
        button3.setText("Delete Minimum");
        button3.addActionListener(e -> button3ActionPerformed(e));

        //---- textField2 ----
        textField2.setEditable(false);
        textField2.setBackground(Color.white);

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
        sorttex.setEditable(false);
        sorttex.setBackground(Color.white);

        //---- Swap ----
        Swap.setText("Action Made");

        //---- selection ----
        selection.setText("Selection");

        //---- heapsort ----
        heapsort.setText("HeapSort");

        //---- table1 ----
        table1.setModel(new DefaultTableModel(
                new Object[][]{
                        {"QuickSort", "MergeSort", "Selection", "HeapSort"},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                },
                new String[]{
                        null, null, null, null
                }
        ) {
            boolean[] columnEditable = new boolean[]{
                    false, true, true, true
            };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        });
        {
            TableColumnModel cm = table1.getColumnModel();
            cm.getColumn(0).setResizable(false);
        }
        table1.setCellSelectionEnabled(true);
        table1.setAutoCreateRowSorter(true);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table1.setBackground(SystemColor.controlHighlight);
        table1.setFont(new Font("Arial", table1.getFont().getStyle(), table1.getFont().getSize()));
        table1.setOpaque(false);
        table1.setForeground(Color.black);
        table1.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));

        //---- sort ----
        sort.setText("Sort");
        sort.addActionListener(e -> sortActionPerformed(e));

        //---- button2 ----
        button2.setText("Reset");
        button2.addActionListener(e -> button2ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sort, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(sorttex, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                                        .addComponent(MergeSort, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(Quicksort, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(selection)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(heapsort)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(29, 29, 29)
                                                                .addComponent(textField2, GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                                .addGap(0, 159, Short.MAX_VALUE)
                                                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(table1, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(Swap, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addComponent(button3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button2)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 18, Short.MAX_VALUE)))
                                .addGap(15, 15, 15))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(table1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button3)
                                        .addComponent(button2)
                                        .addComponent(button1)
                                        .addComponent(scrollPane1))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(MergeSort)
                                        .addComponent(Quicksort)
                                        .addComponent(selection)
                                        .addComponent(heapsort))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sorttex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(sort))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Swap)
                                .addGap(3, 3, 3))
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
    private JButton button3;
    private JTextField textField2;
    private JLabel label1;
    private JLabel label2;
    private JRadioButton Quicksort;
    private JRadioButton MergeSort;
    private JTextField sorttex;
    private JLabel Swap;
    private JRadioButton selection;
    private JRadioButton heapsort;
    private JTable table1;
    private JButton sort;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
