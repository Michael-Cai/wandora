/*
 * WANDORA
 * Knowledge Extraction, Management, and Publishing Application
 * http://wandora.org
 * 
 * Copyright (C) 2004-2014 Wandora Team
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 
 * DataStructure.java
 *
 * Created on 24. marraskuuta 2004, 16:27
 */

package org.wandora.application.tools.extractors.datum;

/**
 *
 * @author  olli
 */
public class DataStructure {
    
    /** Creates a new instance of DataStructure */
    public DataStructure() {
    }
    public DataStructure(Object handle,String type,String source) {
        this.handle=handle;
        this.type=type;
        this.source=source;
    }
    public String type;
    public Object handle;
    public String source;
    public Object store;
}