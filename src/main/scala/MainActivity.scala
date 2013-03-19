package luc.edu.temp

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.view.View
import _root_.android.widget
import _root_.android.widget.TextView.OnEditorActionListener
import _root_.android.widget.TextView
import _root_.android.view.KeyEvent
import _root_.android.view.inputmethod.EditorInfo
import _root_.android.widget.RelativeLayout
import _root_.android.content.Context
import _root_.android.text.TextWatcher
import _root_.android.text.Editable

class MainActivity extends Activity with TypedActivity {
  
  	 lazy val textview= findView(TR.textview)
	  var  celsiusField=findView(TR.celsiusField)		
	  var fahrenheitField= findView(TR.fahrenheitField)
	var converter = new TemperatureConverter(22)
   override def onCreate(bundle: Bundle) {
    super.onCreate(bundle)
    setContentView(R.layout.main)
    textview.setText("Code in Scala")
    celsiusField.setText(converter.degreesCelsius.toString())
    fahrenheitField.setText(converter.getFahrenheit.toString())
  }
  
  	def clearFieldsClicked(view: View)
  	{
  	  celsiusField.setText("")
  	  fahrenheitField.setText("")
  	}
  	
  	 
  	  	celsiusField.setOnEditorActionListener(
  	  	    new OnEditorActionListener(){
          def onEditorAction( textView: TextView, actionId: Int, e: KeyEvent)= {
            if( actionId == EditorInfo.IME_ACTION_DONE ){  fahrenheitField.setText("")
              true}
            else false
          }
        })
      
//  	celsiusField.addTextChangedListener(new TextWatcher() {
//    		override def onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
////				fahrenheitField.setText("111")
//    		}
//
//    		override def afterTextChanged(s: Editable) {
//    			// do nothing
//    		}
//
//    		override def beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
//    			// do nothing
//    		}
//    	})
    	
    	
    	
    def update() = {
        fahrenheitField.setText("") 
          true
        }
  	
  	def celsiusFieldOnClicked(view: View){
  	  converter.degreesCelsius = celsiusField.getText.toString().toDouble
  	  fahrenheitField.setText(converter.getFahrenheit.toString)

  	}
  	def fahrenheitFieldOnClicked(view: View){
  	  converter.setFahrenheit( fahrenheitField.getText.toString().toDouble)
  	  celsiusField.setText(converter.degreesCelsius.toString)
  	}
  	  	

}
