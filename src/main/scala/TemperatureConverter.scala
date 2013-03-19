package luc.edu.temp


/**
 * @author shell
 * * <p>
 * The model that contains the "business logic" for the temperature converter.
 * Think of the converter as a black box that can take temperatures in any
 * supported scale (currently just Fahrenheit and Celsius) and stores them in
 * an internal format (which happens to be Celsius, so other scales get
 * converted before they're stored). Then, you can query the "black box" for
 * the current temperature in any supported scale.
 * </p><p>
 * This conceptual model would make it easy to add additional temperature
 * scales (say, Kelvin) by supplying only another getter and setter, rather
 * than having to write NxN conversion methods (C to K, K to C, F to K,
 * K to F...).
 * </p>
 */
class TemperatureConverter (var degreesCelsius:Double){
  
	def getFahrenheit = degreesCelsius * 9 / 5 + 32
	
	
	def setFahrenheit(value : Double)
	{
	  degreesCelsius = (value - 32) * 5 / 9
	}
	
	
}