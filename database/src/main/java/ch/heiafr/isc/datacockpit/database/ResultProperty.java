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
package ch.heiafr.isc.datacockpit.database;

import java.io.Serializable;




public class ResultProperty extends Property implements Serializable {
	private static final long serialVersionUID = 1L;

	public ResultProperty(String name, String value) {
		super(name, value);
	}

	public ResultProperty(String name, double value) {
		super(name, value+"");
	}

	public ResultProperty(String name, String value, String unit) {
		super(name, value, unit);
	}

	public ResultProperty(String name, double value, String unit) {
		super(name,value+"", unit);
	}

	public ResultProperty(String name, boolean b) {
		super(name, b+"");	
	}
}
