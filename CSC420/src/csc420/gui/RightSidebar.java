/*
 * The MIT License
 *
 * Copyright 2017 chasetoy.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package csc420.gui;

import csc420.AppEventManager;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author chasetoy
 */
public class RightSidebar extends JPanel{
    RightSidebar rightSideBar;
    JButton followers;
    JButton following;
    JButton retweets;
    JButton refresh;
    
    public RightSidebar(){
        initComponents();
    }
    
    private void initComponents(){
        setOpaque(true);
        Color twitter = new Color(0,132,180);
        setBackground(twitter);
        Dimension dim1 = getPreferredSize();
        dim1.width = 250;
        setPreferredSize(dim1);
        followers = new JButton("Followers"){
            {
                setSize(100, 50);
                setMaximumSize(getSize());
            }
        };
        following = new JButton("Following"){
            {
                setSize(100, 50);
                setMaximumSize(getSize());
            }
        };
        retweets = new JButton("Retweets"){
            {
                setSize(100, 50);
                setMaximumSize(getSize());
            }
        };
        refresh = new JButton("Refresh"){
            {
                setSize(100, 50);
                setMaximumSize(getSize());
            }
        };
        followers.setAlignmentX(Component.CENTER_ALIGNMENT);
        following.setAlignmentX(Component.CENTER_ALIGNMENT);
        retweets.setAlignmentX(Component.CENTER_ALIGNMENT);
        refresh.setAlignmentX(Component.CENTER_ALIGNMENT);
        setBackground(twitter);
        initButtons();
        add(followers);
        add(following);
        add(retweets);
        add(refresh);
        followers.setSize(dim1);
        setLayout(new GridLayout(4,1));
    }
    
    public void initButtons(){
        followers.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("followers button was pressed!");
            } 
        });
        following.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("following button was pressed!");
            }
        });
        retweets.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.out.println("retweets button was pressed!");
            }
        });
        refresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                AppEventManager.resetSession();
                AppEventManager.updateResultsPanel();
            }
        });
    }
}
