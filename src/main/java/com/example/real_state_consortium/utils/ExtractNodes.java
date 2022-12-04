package com.example.real_state_consortium.utils;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

@FunctionalInterface
public interface ExtractNodes {
    ArrayList<Node> cathchNode(AnchorPane an);
}
