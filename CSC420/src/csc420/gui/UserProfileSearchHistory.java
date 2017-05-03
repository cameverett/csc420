/*
 * The MIT License
 *
 * Copyright 2017 cam.
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

import csc420.models.TwitterUser;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 *
 * @author cam
 */
public class UserProfileSearchHistory extends JPanel {
    JList<TwitterUser> searchHistory;
    
    TwitterUser[] dummyData = {
        new TwitterUser(0, "gradle", 1024, "https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F.png"),
        new TwitterUser(1, "java", 2048, "https://pbs.twimg.com/profile_images/426420605945004032/K85ZWV2F.png")
    }; 
    public UserProfileSearchHistory() {
        searchHistory = new JList<>(dummyData);
        
        initComponents();
    }
    
    private void initComponents() {
        searchHistory.setCellRenderer(new UserProfileSearchHistoryListCell());
        add(searchHistory);
    }
}
