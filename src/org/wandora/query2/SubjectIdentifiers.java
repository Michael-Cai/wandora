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
 *
 *
 * SubjectIdentifiers.java
 *
 *
 */
package org.wandora.query2;
import java.util.*;
import org.wandora.topicmap.*;

/**
 *
 * @author olli
 */
public class SubjectIdentifiers extends Directive {

    public void SubjectIdentifiers(){

    }

    @Override
    public ResultIterator queryIterator(QueryContext context, ResultRow input) throws QueryException {
        Object o=input.getActiveValue();
        if(o==null) return new ResultIterator.EmptyIterator();
        try{
            if(!(o instanceof Topic)){
                TopicMap tm=context.getTopicMap();
                o=tm.getTopic(o.toString());
                if(o==null) return new ResultIterator.EmptyIterator();
            }
            Collection<Locator> sis=((Topic)o).getSubjectIdentifiers();
            ArrayList<ResultRow> ret=new ArrayList<ResultRow>();
            for(Locator si : sis){
                ret.add(input.addValue(Directive.DEFAULT_COL,si.toString()));
            }
            return new ResultIterator.ListIterator(ret);
        }catch(TopicMapException tme){
            throw new QueryException(tme);
        }
    }

}