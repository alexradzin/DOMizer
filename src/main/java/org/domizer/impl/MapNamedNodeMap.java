package org.domizer.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.domizer.GenericNode;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class MapNamedNodeMap implements NamedNodeMap {
	private final Map<String, String> map;
	private final Node parent;
	private final List<String> indexes;
	

	public MapNamedNodeMap(Node parent, Map<String, String> map) {
		super();
		this.parent = parent;
		this.map = map;
		this.indexes = new ArrayList<String>(map.size());
		
		for (String name : map.keySet()) {
			indexes.add(name);
		}
	}

	@Override
	public Node getNamedItem(String name) {
		return node(name, map.get(name));
	}

	@Override
	public Node setNamedItem(Node node) throws DOMException {
		String name = node.getNodeName();
		return node(name, map.put(name, node.getNodeValue()));
	}

	@Override
	public Node removeNamedItem(String name) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node item(int index) {
		String name = indexes.get(index);
		return name == null ? null : node(name, map.get(name));
	}

	@Override
	public int getLength() {
		return map.size();
	}

	@Override
	public Node getNamedItemNS(String namespaceURI, String localName)
			throws DOMException {
		throw new UnsupportedOperationException("Namespaces are not supported");
	}

	@Override
	public Node setNamedItemNS(Node arg) throws DOMException {
		throw new UnsupportedOperationException("Namespaces are not supported");
	}

	@Override
	public Node removeNamedItemNS(String namespaceURI, String localName)
			throws DOMException {
		throw new UnsupportedOperationException("Namespaces are not supported");
	}

	
	private Node node(String name, String value) throws DOMException {
		return value == null ? null : new GenericNode(name, value, Node.ATTRIBUTE_NODE, null, parent);
	}
	
}
