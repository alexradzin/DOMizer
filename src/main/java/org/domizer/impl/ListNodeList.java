package org.domizer.impl;

import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ListNodeList implements NodeList {
	private final List<?> list;
	
	public ListNodeList(List<?> list) {
		super();
		this.list = list;
	}

	@Override
	public Node item(int index) {
		return index < 0 || index > list.size() - 1 ? null : NodeFactory.createNode(list.get(index));
	}

	@Override
	public int getLength() {
		return list.size();
	}
}
