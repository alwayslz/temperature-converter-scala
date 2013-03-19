package luc.edu.temp
import _root_.android.app.{Activity, Dialog}
import _root_.android.view.View

case class TypedResource[T](id: Int)
case class TypedLayout(id: Int)

object TR {
  val celsiusField = TypedResource[android.widget.EditText](R.id.celsiusField)
  val clearFields = TypedResource[android.widget.Button](R.id.clearFields)
  val Submit02 = TypedResource[android.widget.Button](R.id.Submit02)
  val celsiusLabel = TypedResource[android.widget.TextView](R.id.celsiusLabel)
  val fahrenheitField = TypedResource[android.widget.EditText](R.id.fahrenheitField)
  val textview = TypedResource[android.widget.TextView](R.id.textview)
  val Submit01 = TypedResource[android.widget.Button](R.id.Submit01)
  val fahrenheitLabel = TypedResource[android.widget.TextView](R.id.fahrenheitLabel)
 object layout {
  val main = TypedLayout(R.layout.main)
 }
}
trait TypedViewHolder {
  def findViewById( id: Int ): View
  def findView[T](tr: TypedResource[T]) = findViewById(tr.id).asInstanceOf[T]
}
trait TypedView extends View with TypedViewHolder
trait TypedActivityHolder extends TypedViewHolder
trait TypedActivity extends Activity with TypedActivityHolder
trait TypedDialog extends Dialog with TypedViewHolder
object TypedResource {
  implicit def layout2int(l: TypedLayout) = l.id
  implicit def view2typed(v: View) = new TypedViewHolder { 
    def findViewById( id: Int ) = v.findViewById( id )
  }
  implicit def activity2typed(a: Activity) = new TypedViewHolder { 
    def findViewById( id: Int ) = a.findViewById( id )
  }
  implicit def dialog2typed(d: Dialog) = new TypedViewHolder { 
    def findViewById( id: Int ) = d.findViewById( id )
  }
}
