package org.domizer;

import java.util.LinkedHashMap;
import java.util.Map;

import org.domizer.impl.MapNamedNodeMap;
import org.domizer.impl.NodeFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public class GenericNode implements Node {
	private final String name;
	private String value;
	private final short type;
	private final Object object;
	private final Node parent;

	
	public GenericNode(String name, String value, short type, Object object, Node parent) {
		super();
		this.name = name;
		this.value = value;
		this.type = type;
		this.object = object;
		this.parent = parent;
	}

	@Override
	public String getNodeName() {
		return name;
	}

	@Override
	public String getNodeValue() throws DOMException {
		return value;
	}

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		this.value = nodeValue;
	}

	@Override
	public short getNodeType() {
		return type;
	}

	@Override
	public Node getParentNode() {
		return parent;
	}

	@Override
	public NodeList getChildNodes() {
		return NodeFactory.createNodeList(object);
	}

	@Override
	public Node getFirstChild() {
		NodeList children = getChildNodes();
		int n = children.getLength();
		return n < 1 ? null : children.item(0);
	}

	@Override
	public Node getLastChild() {
		NodeList children = getChildNodes();
		int n = children.getLength();
		return n < 1 ? null : children.item(n - 1);
	}

	@Override
	public Node getPreviousSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getNextSibling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamedNodeMap getAttributes() {
		if (!(this instanceof Element)) {
			return null;
		}
		Map<String, String> attrs = new LinkedHashMap<>();
		NodeList children = getChildNodes();
		int n = children.getLength();
		for (int i = 0; i < n; i++) {
			Node child = children.item(i);
			if (child instanceof Attr) {
				Attr attr = (Attr)child;
				attrs.put(attr.getName(), attr.getValue());
			}
		}
		
		return new MapNamedNodeMap(this, attrs);
	}

	@Override
	public Document getOwnerDocument() {
		// TODO Auto-generated method stub
		Node node = this;
		for (; !(node instanceof Document); node = node.getParentNode()) {
			// do nothing
		}
		return (Document)node;
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node removeChild(Node oldChild) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node appendChild(Node newChild) throws DOMException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildNodes() {
		return getChildNodes().getLength() > 0;
	}

	@Override
	public Node cloneNode(boolean deep) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void normalize() {
		// seems that nothing to do here
	}

	@Override
	public boolean isSupported(String feature, String version) {
		// no features so far...
		return false;
	}

	@Override
	public String getNamespaceURI() {
		return null; // namespace is unsupported
	}

	@Override
	public String getPrefix() {
		return null; // namespace is unsupported
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		// namespace is unsupported
	}

	@Override
	public String getLocalName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasAttributes() {
		NamedNodeMap attrs = getAttributes();
		return attrs != null && attrs.getLength() > 0;
	}

	@Override
	public String getBaseURI() {
		return null;
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTextContent() throws DOMException {
		return value;
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		value = textContent;
	}

	@Override
	public boolean isSameNode(Node other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		return namespaceURI == null;
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		return null;
	}

	@Override
	public boolean isEqualNode(Node arg) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getFeature(String feature, String version) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getUserData(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
