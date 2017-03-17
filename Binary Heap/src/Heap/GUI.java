package Heap;

/**
 * Created by ICY on 3/16/2017.
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame {
    public Heappy tree;
    public Representation node;
    public DrawTree drawer;
    public int index;
    private JPanel contentPane;
    private JButton button1;
    private JTextArea textArea1;
    private JTextField textField1;

    /**
     * Create the frame.
     */
    public GUI(Heappy tree, Representation rep) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        drawer = new DrawTree(tree, rep);
        contentPane.add(drawer);
        setContentPane(contentPane);
        this.tree = tree;
        setVisible(true);


    }

    class DrawTree extends JPanel {

        public Heappy tree;
        public Representation rep;
        int i;

        public DrawTree(Heappy tree, Representation rep) {
            this.tree = tree;
            this.rep = rep;
        }

        public int getdata(int index) {

            return tree.getTree().get(index);
        }


        @Override
        protected void paintComponent(Graphics g) {
            g.setFont(new Font("Tahoma", Font.BOLD, 20));
            g.drawString(String.valueOf(tree.parent(i)), this.getWidth() / 2, 30);
            try {
                DrawNode(g, 0, 100, 50, 2);
                System.out.println("START new");


            } catch (Exception e) {
                System.out.println("PAINT COMP " + e.getMessage());
            }


        }

        public void DrawNode(Graphics g, int i, int w, int h, int q) {
            int old = w;
            while (i != rep.getSize()) {

                System.out.print(getdata(i) + " ");
                System.out.println("SIZE" + rep.getSize() + " i= " + i);
                if (rep.hasParent(i)) {
                    if (rep.hasLeftChild(i)) {
                        g.drawString(String.valueOf(getdata(rep.leftIndex(i))), (this.getWidth() / q) - w, h + 50);
                        System.out.print("LEFT" + tree.Left(i) + "\n");

                    }
                    if (rep.hasRightChild(i)) {
                        g.drawString(String.valueOf(getdata(rep.rightIndex(i))), (this.getWidth() / q) + w, h + 50);
                        System.out.print("Right " + tree.right(i) + "\n");

                    }
                }

                i++;
            }
        }
    }
}
