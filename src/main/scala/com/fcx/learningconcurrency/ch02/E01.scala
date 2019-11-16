package com.fcx.learningconcurrency.ch02

/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/10 10:10
 */
object E01 {

}

package temp {
  import com.fcx.learningconcurrency._

  object ThreadMain extends App {
    val t: Thread = Thread.currentThread()
    val name = t.getName
    println(s"I am the thread $name")
  }

  object ThreadCreation extends App {

    class MyThread extends Thread {
      override def run() {
        println("New thread running.")
      }
    }

    val t = new MyThread
    t.start()
    t.join()
    println("New thread joined.")
  }


  object ThreadSleep extends App {
//    import com.fcx.learningconcurrency._

    val t = thread {
      Thread.sleep(1000)
      log("New thread running")
      Thread.sleep(1000)
      log("still running.")
      Thread.sleep(1000)
      log("complete")
    }

    t.join()
    log("New thread joined.")
  }

  object ThreadNondeterminism extends App{
//    import com.fcx.learningconcurrency._

    val t = thread { log("New thread running.") }
    log("...")
    log("...")
    t.join()
    log("New thread joined.")
  }

  object ThreadsCommunicate extends App{
//    import
    var result: String = null
    val t = thread { result = "\nresult\n" + "=" * 5}
    t.join()
    log(result)
  }

  object SychronizedNesting extends App{
    import scala.collection._

    private val transfers = mutable.ArrayBuffer[String]()
    def logTransfers(name: String, n: Int) = transfers.synchronized{
      transfers += s"transfer to account '$name' = $n"
    }
  }

}