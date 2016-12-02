package com.maths;

public class AdvancedCalculator {

	
	
	
	public AdvancedCalculator(){};
	
	public static double df(double x,Calculator calc){
		
			double total=0;
		
			
			double dx=0.001;
		    double i_2dx=500;
			
		    //total=(calc.f(x+dx)-calc.f(x-dx))/(2*dx);		
		    total=(calc.f(x+dx)-calc.f(x-dx))*i_2dx;	
			return total;
	
	}
	
	public static double SimpsonIntegral(Calculator calc) {

		double x1 = calc.a;
		double x2 = calc.b;
		double total = (calc.f(x1) + calc.f(x2));

		int num = 1000;

		double dx = (x2 - x1) / num;

		for (double i = 2; i < num - 1; i+=2) {
			double x = x1 + dx * i;
			total += 2.0 * calc.f(x);
		}
		for (double i = 1; i < num; i+=2) {
			double x = x1 + dx * i;
			total += 4.0 * calc.f(x);
		}
		return total * dx / 3.0;

	}
	
	
	public static double trapeziumIntegral(Calculator calc) {

		double x1 = calc.a;
		double x2 = calc.b;
		double total = 0.5 * (calc.f(x1) + calc.f(x2));

		int num = 1000;

		double dx = (x2 - x1) / num;

		for (double i = 1; i < num; i++) {

			// total+=dx*(calc.f(x+dx)-calc.f(x-dx))/2;
			// total+=(calc.f(x+dx)+calc.f(x));
			double x = x1 + dx * i;
			total = total + calc.f(x);
		}

		return total * dx;

	}

	public static double gaussIntegral(Calculator calc) {
		
		double total=0;
		
		double x1=calc.a;
		double x2=calc.b;
		
		int num=1000;
		
		double dx=(x2-x1)/num;
		double dx_2=dx/2;
		
		double[] xrg={-Math.sqrt((35+2*Math.sqrt(70))/63.0),
				-Math.sqrt((35-2*Math.sqrt(70))/63.0),
				0,
				Math.sqrt((35-2*Math.sqrt(70))/63.0),
				Math.sqrt((35+2*Math.sqrt(70))/63.0)};
		
		double[] bg={(-455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				(455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				128.0/225.0,
				(455+161*Math.sqrt(70))/(450*Math.sqrt(70)),
				(-455+161*Math.sqrt(70))/(450*Math.sqrt(70))
		
		};
		
		for(double x=x1;x<x2;x=x+dx){
		
	       for(int j=0;j<xrg.length;j++){
	    	   
	    	   double xg=xrg[j]*(dx)*0.5+(2*x+dx)*0.5;
	    	   total+=bg[j]*calc.f(xg);
	       }
		}
		
		return total*dx_2;
	}
}
