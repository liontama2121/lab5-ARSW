package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("RedundancyFilter")
public class RedundancyFilter implements BlueprintsFilter {
    @Override
    public Blueprint filter(Blueprint bp) {
        ArrayList<Point> points=new ArrayList<Point>();
        for (Point i :bp.getPoints()){
            boolean found=false;
            for(Point j : points){
                if(i.equals(j)){
                    found=true;
                    break;
                }
            }
            if(!found)points.add(i);
        }
        return new Blueprint(bp.getAuthor(),bp.getName(),points);
    }

}