package com.fcx.learningconcurrency.ch03

import com.fcx.learningconcurrency._
/**
 * Author: Will Fan
 * Description: TODO
 * Created: 2019/11/24 12:28
 */
object ObjectLazyUnderhood extends App {
  @volatile private var _bitmap = false
  private var _obj: AnyRef = _
  def obj = if (_bitmap) _obj else this.synchronized{
    if (!_bitmap) {
      _obj = new AnyRef
      _bitmap = true
    }
    _obj
  }

  log(s"$obj")
  log(s"$obj")

}
