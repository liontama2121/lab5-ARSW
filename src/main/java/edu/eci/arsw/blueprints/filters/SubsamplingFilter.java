package edu.eci.arsw.blueprints.filters;

import edu.eci.arsw.blueprints.model.Blueprint;
import edu.eci.arsw.blueprints.model.Point;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("SubsamplingFilter")
public class SubsamplingFilter implements BlueprintsFilter {
    @Override
    public Blueprint filter(Blueprint bp) {
        List<Point> oldPoints=bp.getPoints();
        ArrayList<Point> points=new ArrayList<Point>();
        for(int i=0;i<oldPoints.size();i++){
            if(i%2==0){
                points.add(oldPoints.get(i));
            }
        }
        return new Blueprint(bp.getAuthor(),bp.getName(),points);
    }

}