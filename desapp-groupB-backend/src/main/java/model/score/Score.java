package model.score;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.utils.Entity;

public class Score extends Entity{

    private Double value;
    private ScoreType scoreType;
    
    
    public Score() {
		super();
	}

	public ScoreType getScoreType() {
		return scoreType;
	}

	public Score(ScoreType aScoreType) {
    	scoreType = aScoreType;
    	value = 5.0d;
    }

    public void setValue(Double aValue) {
    	value = aValue;
    }
    public Double getValue() {
        return value;
    }

	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}
    
    public String description() {
    	return this.scoreType.description();
    }
    
    public static ScoreType fromCode(String description) {
        for (ScoreType type : maybeScoreTypes()){
            if (type.description().equals(description)){
                return type;
            }
        }
        throw new UnsupportedOperationException();
    }

	private static List<ScoreType> maybeScoreTypes() {
		List<ScoreType> maybeTyes = new ArrayList<ScoreType>();
		maybeTyes.add(new LesseeScoreType());
		maybeTyes.add(new OwnerScoreType());
		maybeTyes.add(new VehicleScoreType());
		return maybeTyes;
	}
}
