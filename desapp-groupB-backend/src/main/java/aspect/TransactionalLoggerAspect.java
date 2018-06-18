package aspect;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

public class TransactionalLoggerAspect {
	
	private Logger log = Logger.getLogger(TransactionalLoggerAspect.class);
	

	@After("execution(*persistence.generic..*(..))")
	public void log(JoinPoint point) {
		String infoResult = getInfo(point).stream().collect(Collectors.joining(""));
		log.info("# trace" + LocalDateTime.now() + " -> " + infoResult);
	}

	private List<String> getInfo(JoinPoint point) {
		List<String> info = new ArrayList<String>();
		info.add(point.getTarget().getClass().getSimpleName());
		info.add(" -> " + point.getSignature().getName());
		info.add("( " + this.argsToString(point.getArgs())+ " )");
		return info;
	}

	private String argsToString(Object[] args) {
		String result = "";
		Boolean isStart = true;
		for (Object argument : args) {
			if(isStart){
				isStart = false;
			}
			else{
				result += ", ";
			}
			result += argument;
		}
		return result;
	}

}
