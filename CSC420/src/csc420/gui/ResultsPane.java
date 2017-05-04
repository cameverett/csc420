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
import csc420.models.TwitterUser;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedGraph;
import edu.uci.ics.jung.graph.UndirectedSparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.control.CrossoverScalingControl;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;
import javax.swing.JPanel;

/**
 *
 * @author chasetoy
 */
public class ResultsPane extends JPanel {
    BasicVisualizationServer<TwitterUser, String> vv;
    Layout<TwitterUser, String> layout;
    UndirectedGraph<TwitterUser, String> dg;
    TwitterUser currentUser;
    public ResultsPane(){
        AppEventManager.setResultsPanel(this);
        dg = new UndirectedSparseMultigraph<>();
        layout = new CircleLayout(dg);
        vv = new BasicVisualizationServer<>(layout);
        initComponents();
    }
    
    public void getData(TwitterUser currentUser, Collection<TwitterUser> twitterUsers) {
        for(TwitterUser node : dg.getVertices()) {
            dg.removeVertex(node);
            System.out.println(dg.getEdgeCount());
        }
        
        this.currentUser = currentUser;
        dg.addVertex(this.currentUser);
        
        for(TwitterUser user : twitterUsers) {
            if(user.equals(this.currentUser)) 
                break;
            dg.addVertex(user);
            dg.addEdge(
                    user.getId() + " -> " + this.currentUser.getId(),
                    user,
                    this.currentUser
            );
        }
        
        System.out.println(dg.toString());
        
    }
    
    private void initComponents(){
        setOpaque(true);
        Color twitter = new Color(0,204,255);
        setBackground(twitter);
        Dimension dim1 = getPreferredSize();
        dim1.width = 250;
        setPreferredSize(dim1);
        
        layout.setSize(new Dimension(450, 450));
        vv.setPreferredSize(new Dimension(500, 500));
        ScalingControl scaling = new CrossoverScalingControl();
        scaling.scale(vv, 1 / 1.1f, vv.getCenter());
        add(vv);
    }
}
