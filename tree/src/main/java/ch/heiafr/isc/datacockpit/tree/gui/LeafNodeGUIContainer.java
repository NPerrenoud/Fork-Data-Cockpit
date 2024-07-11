/*
 * This file is part of one of the Data-Cockpit libraries.
 * 
 * Copyright (C) 2024 ECOLE POLYTECHNIQUE FEDERALE DE LAUSANNE (EPFL)
 * 
 * Author - Sébastien Rumley (sebastien.rumley@hefr.ch)
 * 
 * This open source release is made with the authorization of the EPFL,
 * the institution where the author was originally employed.
 * The author is currently affiliated with the HEIA-FR, which is the actual publisher.
 * 
 * The Data-Cockpit program is free software, you can redistribute it and/or modify
 * it under the terms of GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * The Data-Cockpit program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * Contributor list -
 */
package ch.heiafr.isc.datacockpit.tree.gui;

import java.awt.Color;
import java.awt.LayoutManager;

import ch.heiafr.isc.datacockpit.tree.tree_model.AbstractChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.ArrayChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.BooleanChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.ClassChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.EnumChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.ErrorChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.LeafChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.TypableChooseNode;
import ch.heiafr.isc.datacockpit.tree.tree_model.UntypableArrayInstanceNode;

public class LeafNodeGUIContainer extends AbstractGUIContainer {
	
	private static Color lightGreen = new Color(0.8f, 1f, 0.8f);
	private static Color error = new Color(1f, 0.9f, 0.7f);	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public LeafNodeGUIContainer(LeafChooseNode node, LayoutManager man, int prefix) {
		super(node, man, prefix);
		this.setBackground(lightGreen);			
		refresh();
	}

	@Override
	public void refreshImpl() {
		AbstractChooseNode parent = (AbstractChooseNode)absNode.getParent();
		if (parent instanceof BooleanChooseNode) {
			setIcon("boolean.png");
		} else if (parent instanceof EnumChooseNode) {
			setIcon("class.png");
		} else if (parent instanceof UntypableArrayInstanceNode) {
			setIcon("class.png");
		} else if (parent instanceof ArrayChooseNode){
			setIcon("other.png");
		} else if (parent instanceof ClassChooseNode) {
			setIcon("other.png");
			// sanity check
			if (!(absNode instanceof LeafChooseNode)) {
				throw new IllegalStateException();
			} 
			if (!((LeafChooseNode)absNode).isNull()) {
				if (!(absNode instanceof ErrorChooseNode))
					throw new IllegalStateException();		
				else
					this.setBackground(error);	
			}
		} else {
			TypableChooseNode p = (TypableChooseNode)absNode.getParent();
			if (p.isBoolean()) {
				setIcon("boolean.png");
			} else if (p.isInt()) {
				setIcon("integer.png");
			} else if (p.isClass()) {
				setIcon("class.png");
			} else if (p.isDouble()) {
				setIcon("double.png");
			} else if (p.isLong()) {
				setIcon("long.png");
			} else {
				setIcon("other.png");
			}
		}
	}
	

}

