import arrow.Kind
import arrow.core.*
import arrow.data.ListK
import arrow.data.foldable
import arrow.data.k
import arrow.instances.*
import arrow.typeclasses.Foldable

object FoldableSample {
  @JvmStatic
  fun main(args: Array<String>) {

    val maybeStr = Some("abc")
    val strList = listOf("a", "b", "c").k()

    fold(maybeStr, Option.foldable())
    foldLeft(maybeStr, Option.foldable())
    foldRight(maybeStr, Option.foldable())
    fold(None, Option.foldable())
    foldLeft(None, Option.foldable())
    foldRight(None, Option.foldable())
    fold(strList, ListK.foldable())
    foldLeft(strList, ListK.foldable())
    foldRight(strList, ListK.foldable())
  }

  fun <F> fold(strKind: Kind<F, String>, FO : Foldable<F>) {
    with(FO){
      val str = strKind.fold(String.monoid())
      println(str)
    }
  }

  fun<F>  foldRight(strKind: Kind<F, String>, FO : Foldable<F>){
    with(FO){
    val str = strKind.foldRight( Eval.now("str: ") ) { value: String, base: Eval<String> -> base.map { it+value } }
    println(str.value())}
  }

  fun<F>  foldLeft(strKind: Kind<F, String>, FO : Foldable<F>){
    with(FO){
    val str = strKind.foldLeft( "str: " ) { base: String, value: String -> base + value }
    println(str)}
  }

}