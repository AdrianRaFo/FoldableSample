import arrow.core.*
import arrow.data.ListK
import arrow.data.foldable
import arrow.data.k

object FoldableSample : FoldableFunctions {
  @JvmStatic
  fun main(args: Array<String>) {

    val maybeStr = Some("abc")
    val maybeStrOpt = Some("abc".some())
    val strList = listOf("a", "b", "c").k()
    val strNoneList = listOf("a".some(), None, "c".some()).k()
    val strOptList = listOf("a".some(), "b".some(), "c".some()).k()
    val rightStr = Either.right("abc") as Either<String, String>

    println("fold maybeStr " + fold(maybeStr, Option.foldable()))
    println("fold None " + fold(None, Option.foldable()))
    println("fold strList " + fold(strList, ListK.foldable()))

    println("foldLeft maybeStr " + foldLeft(maybeStr, Option.foldable()))
    println("foldLeft None " + foldLeft(None, Option.foldable()))
    println("foldLeft strList " + foldLeft(strList, ListK.foldable()))

    println("foldRight maybeStr " + foldRight(maybeStr, Option.foldable()))
    println("foldRight None " + foldRight(None, Option.foldable()))
    println("foldRight strList " + foldRight(strList, ListK.foldable()))

    println("foldM maybeStr " + foldM(maybeStr, Option.foldable()))
    println("foldM None " + foldM(None, Option.foldable()))
    println("foldM strList " + foldM(strList, ListK.foldable()))

    println("foldMap maybeStr " + foldMap(maybeStr, Option.foldable()))
    println("foldMap None " + foldMap(None, Option.foldable()))
    println("foldMap strList " + foldMap(strList, ListK.foldable()))

    println("reduceLeftOption maybeStr " + reduceLeftOption(maybeStr, Option.foldable()))
    println("reduceLeftOption None " + reduceLeftOption(None, Option.foldable()))
    println("reduceLeftOption strList " + reduceLeftOption(strList, ListK.foldable()))

    println("reduceRightOption maybeStr " + reduceRightOption(maybeStr, Option.foldable()))
    println("reduceRightOption None " + reduceRightOption(None, Option.foldable()))
    println("reduceRightOption strList " + reduceRightOption(strList, ListK.foldable()))

    println("reduceRightToOption maybeStr " + reduceRightToOption(maybeStr, Option.foldable()))
    println("reduceRightToOption None " + reduceRightToOption(None, Option.foldable()))
    println("reduceRightToOption strList " + reduceRightToOption(strList, ListK.foldable()))

    println("combineAll maybeStr " + combineAll(maybeStr, Option.foldable()))
    println("combineAll None " + combineAll(None, Option.foldable()))
    println("combineAll strList " + combineAll(strList, ListK.foldable()))

    println("exists maybeStr " + exists(maybeStr, Option.foldable()))
    println("exists None " + exists(None, Option.foldable()))
    println("exists strList " + exists(strList, ListK.foldable()))

    println("find maybeStr " + find(maybeStr, Option.foldable()))
    println("find None " + find(None, Option.foldable()))
    println("find strList " + find(strList, ListK.foldable()))

    println("forAll maybeStr " + forAll(maybeStr, Option.foldable()))
    println("forAll None " + forAll(None, Option.foldable()))
    println("forAll strList " + forAll(strList, ListK.foldable()))

    println("isEmpty maybeStr " + isEmpty(maybeStr, Option.foldable()))
    println("isEmpty None " + isEmpty(None, Option.foldable()))
    println("isEmpty strList " + isEmpty(strList, ListK.foldable()))

    println("nonEmpty maybeStr " + nonEmpty(maybeStr, Option.foldable()))
    println("nonEmpty None " + nonEmpty(None, Option.foldable()))
    println("nonEmpty strList " + nonEmpty(strList, ListK.foldable()))

    println("traverse maybeStr " + traverse(maybeStr, Option.foldable()))
    println("traverse None " + traverse(None, Option.foldable()))
    println("traverse strList " + traverse(strList, ListK.foldable()))

    println("size maybeStr " + size(maybeStr, Option.foldable()))
    println("size None " + size(None, Option.foldable()))
    println("size strList " + size(strList, ListK.foldable()))

    println("sequence maybeStrOpt " + sequence(maybeStrOpt, Option.foldable()))
    println("sequence None " + sequence(None, Option.foldable()))
    println("sequence strNoneList " + sequence(strNoneList, ListK.foldable()))
    println("sequence strOptList " + sequence(strOptList, ListK.foldable()))

    println("foldableGet " + foldableGet(rightStr))
  }

}