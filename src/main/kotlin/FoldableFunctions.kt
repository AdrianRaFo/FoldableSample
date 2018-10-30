import arrow.Kind
import arrow.core.*
import arrow.instances.either.applicative.applicative
import arrow.instances.either.foldable.foldable
import arrow.instances.either.monad.monad
import arrow.instances.monoid
import arrow.instances.option.applicative.applicative
import arrow.instances.option.monad.monad
import arrow.typeclasses.Foldable

interface FoldableFunctions {

  fun <F> foldLeft(strKind: Kind<F, String>, FO: Foldable<F>): String =
    with(FO) {
      strKind.foldLeft("str: ") { base: String, value: String -> base + value }
    }

  fun <F> foldRight(strKind: Kind<F, String>, FO: Foldable<F>): String =
    with(FO) {
      strKind.foldRight(Eval.now("str: ")) { value: String, base: Eval<String> -> base.map { it + value } }
        .value()
    }

  fun <F> fold(strKind: Kind<F, String>, FO: Foldable<F>): String =
    with(FO) {
      strKind.fold(String.monoid())
    }

  fun <F> combineAll(strKind: Kind<F, String>, FO: Foldable<F>): String =
    with(FO) {
      strKind.combineAll(String.monoid())
    }

  fun <F> reduceLeftToOption(strKind: Kind<F, String>, FO: Foldable<F>): Option<Int> =
    with(FO) {
      strKind.reduceLeftToOption({ it.length }) { base: Int, value: String -> base + value.length }
    }

  fun <F> reduceRightToOption(strKind: Kind<F, String>, FO: Foldable<F>): Option<Int> =
    with(FO) {
      strKind.reduceRightToOption({ it.length }) { value: String, base: Eval<Int> -> base.map { it + value.length } }
        .value()
    }

  fun <F> reduceLeftOption(strKind: Kind<F, String>, FO: Foldable<F>): Option<String> =
    with(FO) {
      strKind.reduceLeftOption { base: String, value: String -> base + value }
    }

  fun <F> reduceRightOption(strKind: Kind<F, String>, FO: Foldable<F>): Option<String> =
    with(FO) {
      strKind.reduceRightOption { value: String, base: Eval<String> -> base.map { it + value } }
        .value()
    }

  fun <F> foldMap(strKind: Kind<F, String>, FO: Foldable<F>): Int =
    with(FO) {
      strKind.foldMap(Int.monoid()) { it.length }
    }

  fun <F> traverse(strKind: Kind<F, String>, FO: Foldable<F>): Either<Int, Unit> =
    with(FO) {
      strKind.traverse_(Either.applicative<Int>()) { Right(it.length) }
    }.fix()

  fun <F> sequence(strKind: Kind<F, Kind<ForOption, String>>, FO: Foldable<F>): Option<Unit> =
    with(FO) {
      strKind.sequence_(Option.applicative())
    }.fix()

  fun <F> find(strKind: Kind<F, String>, FO: Foldable<F>): Option<String> =
    with(FO) {
      strKind.find { it.isNotBlank() }
    }

  fun <F> exists(strKind: Kind<F, String>, FO: Foldable<F>): Boolean =
    with(FO) {
      strKind.exists { it.isNotBlank() }
    }

  fun <F> forAll(strKind: Kind<F, String>, FO: Foldable<F>): Boolean =
    with(FO) {
      strKind.forAll { it.isNotBlank() }
    }

  fun <F> isEmpty(strKind: Kind<F, String>, FO: Foldable<F>): Boolean =
    with(FO) {
      strKind.isEmpty()
    }

  fun <F> nonEmpty(strKind: Kind<F, String>, FO: Foldable<F>): Boolean =
    with(FO) {
      strKind.nonEmpty()
    }

  fun <F> size(strKind: Kind<F, String>, FO: Foldable<F>): Long =
    with(FO) {
      strKind.size(Long.monoid())
    }

  fun <F> foldMapM(strKind: Kind<F, String>, FO: Foldable<F>): Option<Int> =
    with(FO) {
      strKind.foldMapM(Option.monad(), Int.monoid()) { Some(it.length) }
    }.fix()

  fun <F> foldM(strKind: Kind<F, String>, FO: Foldable<F>): Either<String, String> =
    with(FO) {
      strKind.foldM(
        Either.monad<String>(),
        "str: "
      ) { base: String, value: String -> Right(base + value) }
    }.fix()

  fun foldableGet(strKind: EitherOf<String, String>): Option<String> =
    with(Either.foldable<String>()) {
      strKind.get(Either.monad(), 0)
    }

}