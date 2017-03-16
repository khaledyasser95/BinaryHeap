package Heap;

/**
 * Created by ICY on 3/16/2017.
 */

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
    private JPanel contentPane;
    public Heappy tree;
    public Representation node;
    public DrawTree drawer;
    public int index;
    private JButton button1;
    private JTextArea textArea1;

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
        int i = 0;

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
                //   DrawTree(g, 0, getWidth(), 0, getHeight() / 5, tree.parent(i));


            } catch (Exception e) {
                System.out.println("PAINT COMP " + e.getMessage());
            }


        }

        public void DrawNode(Graphics g, int i, int w, int h, int q) {
            try {
                for (i = i; i < rep.getSize(); i++) {
                    System.out.print(getdata(i) + " ");
                    System.out.println("SIZE" + rep.getSize());
                    g.setFont(new Font("Tahoma", Font.BOLD, 20));
                    if (rep.parentIndex(i) <= tree.getTree().size()) {
                        //g.drawString(String.valueOf(getdata(i)), (this.getWidth() / q) + w, h);
                        if (rep.hasLeftChild(i)) {
                            g.drawString(String.valueOf(getdata(rep.leftIndex(i))), (this.getWidth() / q) - w, h + 50);
                            DrawNode(g, rep.leftIndex(i), -w, h * 2, q);
                        }
                        if (rep.hasRightChild(i)) {

                            g.drawString(String.valueOf(getdata(rep.rightIndex(i))), (this.getWidth() / q) + w, h + 50);
                            DrawNode(g, rep.rightIndex(i), w * 2, h * 2, q);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("NODE " + e.getMessage());
            }


        }


        public void DrawTree(Graphics g, int StartWidth, int EndWidth, int StartHeight, int Level, int value) {
            try {
                for (value = value; value <= rep.getSize() - 1; value++) {
                    String data = String.valueOf(getdata(value));
                    g.setFont(new Font("Tahoma", Font.BOLD, 20));
                    FontMetrics fm = g.getFontMetrics();
                    int dataWidth = fm.stringWidth(data);
                    g.drawString(data, (StartWidth + EndWidth) / 2 - dataWidth / 2, StartHeight + Level / 2);

                    if (rep.hasLeftChild(value))
                        DrawTree(g, StartWidth, (StartWidth + EndWidth) / 2, StartHeight + Level, Level, rep.leftIndex(i));
                    if (rep.hasRightChild(value))
                        DrawTree(g, (StartWidth + EndWidth) / 2, EndWidth, StartHeight + Level, Level, rep.rightIndex(i));

                }
            } catch (Exception e) {
                System.out.println("TREE " + e.getMessage());
            }


        }


    }
}
