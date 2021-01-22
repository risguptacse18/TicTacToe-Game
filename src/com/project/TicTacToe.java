package com.project;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener{
    int c=0;
    Random r=new Random();   //
    JFrame frame=new JFrame("TicTacToe Game");
    JPanel titlePanel=new JPanel();
    JPanel buttonsPanel=new JPanel();
    JLabel text=new JLabel();
    JButton buttons[]=new JButton[9];
    boolean player1turn;

    TicTacToe()
    {
        //this will genreate the frame or window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        text.setBackground(new Color(0, 0, 0));
        text.setForeground(new Color(255,255,255));
        text.setFont(new Font("Ink Free",Font.BOLD,75));
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setText("Tic-Tac-Toe");
        text.setOpaque(true);

        titlePanel.setLayout((new BorderLayout()));
        titlePanel.setBounds(0,0,800,100);

        buttonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.setBackground(new Color(150, 150, 150));

        for(int i=0;i<9;i++)
        {
          buttons[i]=new JButton();
          buttonsPanel.add(buttons[i]);
          buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
          buttons[i].setFocusable(false);
          buttons[i].addActionListener(this);
        }

        titlePanel.add(text);
        frame.add(titlePanel,BorderLayout.NORTH);
        frame.add(buttonsPanel);

        firstTurn();

    }

    public void firstTurn()     //will tell who's turn is next
    {
        try {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(r.nextInt(2)==0)
        {
            player1turn=true;
            text.setText("X Turn");
        }
        else
        {
            player1turn=false;
            text.setText("O Turn");
        }
    }

    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<9;i++)
        {
            if(e.getSource()==buttons[i])
            {
                if(player1turn)
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(0,0,0));
                        buttons[i].setText("X");
                        player1turn=false;
                        text.setText("O Turn");
                        check();
                    }
                }
                else
                {
                    if(buttons[i].getText()=="")
                    {
                        buttons[i].setForeground(new Color(255,255,255));
                        buttons[i].setText("O");
                        player1turn=true;
                        text.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }


    public void check()
    {
        //For X wins condition
        if(buttons[0].getText()=="X"&&buttons[1].getText()=="X"&&buttons[2].getText()=="X")
        {
            xWins(0,1,2);
        }
        if(buttons[3].getText()=="X"&&buttons[4].getText()=="X"&&buttons[5].getText()=="X")
        {
            xWins(3,4,5);
        }
        if(buttons[6].getText()=="X"&&buttons[7].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(6,7,8);
        }
        if(buttons[0].getText()=="X"&&buttons[3].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWins(0,3,6);
        }
        if(buttons[1].getText()=="X"&&buttons[4].getText()=="X"&&buttons[7].getText()=="X")
        {
            xWins(1,4,7);
        }
        if(buttons[2].getText()=="X"&&buttons[5].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(2,5,8);
        }
        if(buttons[2].getText()=="X"&&buttons[4].getText()=="X"&&buttons[6].getText()=="X")
        {
            xWins(2,4,6);
        }
        if(buttons[0].getText()=="X"&&buttons[4].getText()=="X"&&buttons[8].getText()=="X")
        {
            xWins(0,4,8);
        }






        //For O wins conditions
        if(buttons[0].getText()=="O"&&buttons[1].getText()=="O"&&buttons[2].getText()=="O")
        {
            oWins(0,1,2);
        }
        if(buttons[3].getText()=="O"&&buttons[4].getText()=="O"&&buttons[5].getText()=="O")
        {
            oWins(3,4,5);
        }
        if(buttons[6].getText()=="O"&&buttons[6].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(6,7,8);
        }
        if(buttons[0].getText()=="O"&&buttons[3].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWins(0,3,6);
        }
        if(buttons[1].getText()=="O"&&buttons[4].getText()=="O"&&buttons[7].getText()=="O")
        {
            oWins(1,4,7);
        }
        if(buttons[2].getText()=="O"&&buttons[5].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(2,5,8);
        }
        if(buttons[2].getText()=="O"&&buttons[4].getText()=="O"&&buttons[6].getText()=="O")
        {
            oWins(2,4,6);
        }
        if(buttons[0].getText()=="O"&&buttons[4].getText()=="O"&&buttons[8].getText()=="O")
        {
            oWins(0,4,8);
        }


        int tie=0;
        for(JButton i:buttons)
        {
            if(i.getText()=="O"||i.getText()=="X")
            {
                tie++;
            }
        }
        if(tie==9)
        {
            for(int c=0;c<9;c++)
            {
                buttons[c].setEnabled(false);
            }
            text.setText("It's a tie");
        }

    }

    public void xWins(int a,int b,int c)   //will check the combination and tell if x wins.
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        text.setText("X Wins");
    }

    public void oWins(int a,int b,int c)   //will check the combination and tell if o wins.
    {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++)
        {
            buttons[i].setEnabled(false);
        }
        text.setText("O Wins");
    }

}
