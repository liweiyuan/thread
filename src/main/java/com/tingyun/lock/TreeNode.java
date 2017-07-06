package com.tingyun.lock;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    TreeNode parent = null;
    List children = new ArrayList();

    public synchronized void addChildren(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.setParentOnly(this);
        }
    }

    public synchronized void setParentOnly(TreeNode parentOnly) {
        this.parent = parentOnly;
    }


    public synchronized void setParent(TreeNode parent) {
        this.parent = parent;
        parent.addChildrenOnly(this);
    }

    private synchronized void addChildrenOnly(TreeNode child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }
}
