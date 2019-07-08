package com.fcx.pis3.ch19

/**
  * Author: Will Fan
  * Date: 2019/4/28 9:04
  */
object Sample19 extends App {
  class SlowAppendQueue[T](elems: List[T]) {
    def head = elems.head
    def tail = new SlowAppendQueue(elems.tail)
    def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
  }

  class SlowHeadQueue[T](smele: List[T]) {
    def head = smele.last
    def tail = new SlowHeadQueue(smele.init)
    def enqueue(x: T) = new SlowHeadQueue(x :: smele)
  }

  class Queue[T] private (
                private val leading: List[T],
                private val trailing: List[T]
                ) {
    def this() = this(Nil, Nil)

//    def this(elems: T*) = this(elems.toList, Nil)

    private def mirror =
      if (leading.isEmpty)
        new Queue(trailing.reverse, Nil)
      else
        this

    def head = mirror.leading.head

    def tail = {
      val q = mirror
      new Queue(q.leading.tail, q.trailing)
    }

    def enqueue(x: T) =
      new Queue(leading, x :: trailing)
  }

  object Queue {
    def apply[T](xs: T*): Queue[T] = new Queue[T] (xs.toList, Nil)
  }
}
