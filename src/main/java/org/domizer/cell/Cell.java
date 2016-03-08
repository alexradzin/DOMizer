package org.domizer.cell;

import java.util.List;

public interface Cell {
	public boolean isLeaf();
	public List<Cell> children();
	
}
